package model;


public class Locacao {
	
    private int idLocacao;  
    private Cliente cliente;
    private Veiculo veiculo;
    private String veiculoRetirada;
    private String veiculoDevolucao;
    private String dataDevolucaoReal;
    private int diasLocados;
    private double valorTotal;
    private double multaAtraso;
    private String locacaoStatus; 
    
    public Locacao() {
    	
    }

    public Locacao(int idLocacao, Cliente cliente, Veiculo veiculo, String veiculoRetirada, String veiculoDevolucao, int diasLocados) {
        this.idLocacao = idLocacao;
        this.locacaoStatus = "Ativa";
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.veiculoRetirada = veiculoRetirada;
        this.veiculoDevolucao = veiculoDevolucao;
        this.dataDevolucaoReal = null;
        this.diasLocados = diasLocados;
        this.multaAtraso = 0.0;
        calcularValorTotal();
    }

    public int getIdLocacao() {
        return idLocacao;
    }

    public void setIdLocacao(int idLocacao) {
        this.idLocacao = idLocacao;
    }
    
    public void devolverVeiculo(String dataReal) {
        this.locacaoStatus = "Finalizada";
        this.dataDevolucaoReal = dataReal;  // Define a data real de devolução
        calcularValorTotal();
    }
    
    public String getLocacaoStatus() {
        return locacaoStatus;
    }

    public void setLocacaoStatus(String locacaoStatus) {
        this.locacaoStatus = locacaoStatus;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public String getDataRetirada() {
        return veiculoRetirada;
    }

    public void setDataRetirada(String veiculoRetirada) {
        this.veiculoRetirada = veiculoRetirada;
    }

    public String getDataDevolucao() {
        return veiculoDevolucao;
    }

    public void setDataDevolucao(String veiculoDevolucao) {
        this.veiculoDevolucao = veiculoDevolucao;
    }
    
    public String getDataDevolucaoReal() {
        return dataDevolucaoReal;
    }

    public void setDataDevolucaoReal(String dataDevolucaoReal) {
        this.dataDevolucaoReal = dataDevolucaoReal;
    }

    public int getDiasLocados() {
        return diasLocados;
    }

    public void setDiasLocados(int diasLocados) {
        this.diasLocados = diasLocados;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getMultaAtraso() {
        return multaAtraso;
    }

    public void setMultaAtraso(double multaAtraso) {
        this.multaAtraso = multaAtraso;
    }

    public void calcularValorTotal() {
    	if (dataDevolucaoReal == null) {
            dataDevolucaoReal = "00-00-00"; 
        }
    	
        String[] retiradaParts = veiculoRetirada.split("-");
        String[] devolucaoPrevistaParts = veiculoDevolucao.split("-");
        String[] devolucaoRealParts = dataDevolucaoReal.split("-"); // Usa a data real de devolução

        int anoRetirada = Integer.parseInt(retiradaParts[0]);
        int mesRetirada = Integer.parseInt(retiradaParts[1]);
        int diaRetirada = Integer.parseInt(retiradaParts[2]);

        int anoDevolucaoPrevista = Integer.parseInt(devolucaoPrevistaParts[0]);
        int mesDevolucaoPrevista = Integer.parseInt(devolucaoPrevistaParts[1]);
        int diaDevolucaoPrevista = Integer.parseInt(devolucaoPrevistaParts[2]);

        int anoDevolucaoReal = Integer.parseInt(devolucaoRealParts[0]);
        int mesDevolucaoReal = Integer.parseInt(devolucaoRealParts[1]);
        int diaDevolucaoReal = Integer.parseInt(devolucaoRealParts[2]);

        // Calcula a quantidade de dias originalmente locados
        int diasPrevistos = (anoDevolucaoPrevista - anoRetirada) * 365 + 
                            (mesDevolucaoPrevista - mesRetirada) * 30 + 
                            (diaDevolucaoPrevista - diaRetirada);

        // Calcula a quantidade total de dias com base na devolução real
        int diasTotais = (anoDevolucaoReal - anoRetirada) * 365 + 
                         (mesDevolucaoReal - mesRetirada) * 30 + 
                         (diaDevolucaoReal - diaRetirada);

        this.diasLocados = diasPrevistos; // Os dias previstos são os dias originalmente locados
        valorTotal = veiculo.calcularCustoLocacao(diasLocados);

        // Calcula a multa apenas se a devolução foi depois da data prevista
        int diasAtraso = diasTotais - diasPrevistos;
        if (diasAtraso > 0) {
            multaAtraso = diasAtraso * 10.0; // Supondo R$10 por dia de atraso
            valorTotal += multaAtraso;
        } else {
            multaAtraso = 0.0;
        }
    }

    public String toString() {
        return "\n--Locação de veículos--" +
                "\n ID Locação= " + idLocacao  +
                "\n locacaoStatus= " + locacaoStatus + 
                "\n Cliente= " + cliente.getNome() + 
                "\n Veículo= " + veiculo.getModelo() + 
                "\n Data de retirada= " + veiculoRetirada +
                "\n Data de devolução prevista= " + veiculoDevolucao +
                "\n Data de devolução real= " + (dataDevolucaoReal != null ? dataDevolucaoReal : "Ainda não devolvido") +
                "\n Dias locados= " + diasLocados +
                "\n Valor Total= " + valorTotal +
                "\n Multa por atraso= " + multaAtraso;
    }
}


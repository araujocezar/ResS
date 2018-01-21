package HistoricoDeColeta

import cucumber.api.Format

class Coleta {

    String nome // nome do estabelecimento
    Date dataColeta // data da coleta
    int volume // volume coletado


    static constraints = {

        nome blank: true // no caso de ser ecoponto pode n�o ter nome
        dataColeta blank: false, nullable: false
        volume  blank: false, nullable: false
    }
    void setName(String novoNome){
        if(Coleta.findByNomeAndData(novoNome,this.dataColeta) == null){
            this.nome = novoNome
        }
    }

    void setDate(@Format("dd/MM/yyyy")Date novaData){
        if(Coleta.findByNomeAndData(this.nome,novaData) == null){
            this.dataColeta = novaData
        }
    }
	
	String toString() {
		return nome;
	}
	
	@Override
	boolean equals(Object obj){
		if (obj instanceof Coleta){
			Coleta coleta = (Coleta) obj
			if(coleta.data  == this.data && coleta.volume == this.volume && coleta.nome == this.nome){
				return true
			}
		}
	return false
	}
	

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nst.controlenst.enums;

/**
 *
 * @author emidio
 */
public enum EnumDAO {
    CARGODAO ("CargoDAO"),
    COORDENADORDAO("CoordenadorDAO"),
    CURSODAO("CursoDAO"),
    EMAILCOORDENADORDAO("EmailCoordenadorDAO"),
    EMAILPARTICIPANTEDAO("EmailParticipanteDAO"),
    HIST_PARTI_DAO("HistoricoParticipanteDAO"),
    HISTO_COOR_DAO("HistoricoCoordenadorDAO"),
    MOTIVO_SAIDA_DAO("MotivoSaidaDAO"),
    PARTI_DAO("ParticipanteDAO"),
    PROJETO_DAO("ProjetoDAO"),
    SITU_DAO("SituacaoDAO"),
    TEL_COOR_DAO("TelefoneCoordenadorDAO"),
    TEL_PARTI_DAO("TelefoneParticipanteDAO"),
    TIPO_DAO("TipoDAO"),
    TIPO_INGRE_DAO("TipoIngressoDAO"),
    VINCU_DAO("VinculoDAO");
    
    private EnumDAO(String tipoDAO){
        this.tipoDAO = tipoDAO;
    }
    
    String tipoDAO = "";
    
    @Override
    public String toString(){
        return this.tipoDAO;
    }
}

package PROJETOS.Iphone;

public class Iphone implements ReprodutorMusical, AparelhoTelefonico, NavegadorInternet{

    @Override
    public void tocar() {
        System.out.println("Musica tocando! 🎵🎵");
    }
    @Override
    public void pausar() {
        System.out.println("Musica pausada! ⏸");
    }
    @Override
    public void selecionarMusica(String musica) {
        System.out.println("Musica " + musica + " selecionada!");
    }

    @Override
    public void ligar(int numero) {
        System.out.println("Ligando para o numero " + numero + " !");
    }
    @Override
    public void atender() {
        System.out.println("Ligacao atendida!");
    }
    @Override
    public void correioDeVoz() {
        System.out.println("Correio de Voz!");
    }

    @Override
    public void novaAba() {
        System.out.println("Nova aba aberta!");
    }
    @Override
    public void abrirPagina(String pagina) {
        System.out.println(pagina + " aberto(a) com sucesso!");
    }
    @Override
    public void atualizarPagina() {
        System.out.println("Pagina atualizada!");
    }

    public static void main(String[] args) {
        ReprodutorMusical spotify = new Iphone();
        AparelhoTelefonico telefone = new Iphone();
        NavegadorInternet safari = new Iphone();
        spotify.selecionarMusica("Beat it");
        spotify.pausar();
        telefone.ligar(992281271);
        safari.abrirPagina("Youtube");
        spotify.tocar();



    }
}

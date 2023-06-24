import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

import excecoes.ClienteNaoProfissional;

public class ClienteUtil {
    public static void perfil(PlataformaStreaming app) {

        Scanner scanner = new Scanner(System.in);
        Cliente user = app.getClienteAtual();

        while (true) {
            System.out.println(
                    "Qual operação deseja fazer?\n1 - Lista de Para ver\n2 - Lista de já assistidos\n3 - Filtrar por Quantidade de Epsodios\n4 - Filtrar Por Gênero\n5 - Filtrar por Idioma\n6 - Assistir Alguma Midia\n7 - Avaliar Mídia\n8 - Minhas Avaliações\n9 - Filtrar top 10 midias com melhor avaliacao - com mais de 100 atualizacoes\n 10 - Filtrar top 10 midias com melhor avaliacao separadas por genero - com mais de 100 atualizacoes \n11 - Filtrar top 10 midias com mais visualizacoes separadas por genero \n12 - Buscar cliente que mais assistiu midias e numero de midias \n 13 - Buscar cliente que mais avaliou midias e o número de midias \n 14 - Busca porcentagem dos clientes que possuem mais de 15 avaliacoes   \n0 - Logout");
            int opt = scanner.nextInt();

            if (opt == 1) {

                Midia[] arr = new Midia[user.getListaParaVer().size()];
                arr = user.getListaParaVer().allElements(arr);
                System.out.println(arr.length);

                for (Midia m : arr) {
                    System.out.println(m.toString() + "\n");
                }

            } else if (opt == 2) {

                for (Map.Entry<Midia, LocalDate> m : user.getListaJaVista().entrySet()) {
                    Midia mJaAssistida = m.getKey();
                    // LocalDate diaDaView = m.getValue();
                    System.out.println(mJaAssistida.toString() + "\n");
                }

            } else if (opt == 3) {
                // filtragem por quantidade de ep
                System.out.println("Digite a quantidade de ep que deseja buscar:");
                int qtdEp = scanner.nextInt();

                Lista<Midia> resultado = app.filtrarPorQtdEpisodios(qtdEp);

                Midia[] arr = new Midia[user.getListaParaVer().size()];
                arr = resultado.allElements(arr);

                if (arr == null) {
                    System.out.println("Nenhuma Mídia foi encontrada");
                } else {
                    System.out.println(arr.length);

                    for (Midia m : arr) {
                        if (m != null) {
                            System.out.println(m.toString() + "\n");
                        }

                    }
                }

            } else if (opt == 4) {
                // filtragem por genero
                System.out.println("Genero (Não utilize acentos nem careacteres especiais): ACAO,\r\n" + //
                        "    ANIME,\r\n" + //
                        "    AVENTURA,\r\n" + //
                        "    COMEDIA,\r\n" + //
                        "    DOCUMENTARIO,\r\n" + //
                        "    DRAMA,\r\n" + //
                        "    POLICIAL,\r\n" + //
                        "    ROMANCE,\r\n" + //
                        "    SUSPENSE");
                try {

                    String genero = scanner.nextLine();
                    Generos generoSelecionado = Generos.valueOf(genero.toUpperCase());

                    Lista<Midia> resultado = user.filtrarPorGenero(generoSelecionado);

                    Midia[] arr = new Midia[user.getListaParaVer().size()];
                    arr = resultado.allElements(arr);

                    if (arr == null) {
                        System.out.println("Nenhuma Mídia foi encontrada");
                    } else {
                        System.out.println(arr.length);

                        for (Midia m : arr) {
                            System.out.println(m.toString() + "\n");
                        }
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                    System.out.println("Genero Inválido");
                }

            } else if (opt == 5) {
                // filtragem por idioma
                System.out.println("Idiomas:\n     PTBR,\r\n" + //
                        "    PTPG,\r\n" + //
                        "    ENG;");
                try {
                    String idioma = scanner.nextLine();

                    Idiomas idiomaSelecionado = Idiomas.valueOf(idioma.toUpperCase());
                    Lista<Midia> resultado = user.filtrarPorIdioma(idiomaSelecionado);

                    Midia[] arr = new Midia[user.getListaParaVer().size()];
                    arr = resultado.allElements(arr);

                    if (arr == null) {
                        System.out.println("Nenhuma Mídia foi encontrada");
                    } else {
                        System.out.println(arr.length);

                        for (Midia m : arr) {
                            System.out.println(m.toString() + "\n");
                        }
                    }

                } catch (Exception e) {
                    // TODO: handle exception
                    System.out.println("Idioma Inválido" + e);
                }
            } else if (opt == 6) {
                System.out.println("Digite o ID da mídia que deseja assistir");

                try {
                    scanner.nextLine();
                    String id = scanner.nextLine();
                    Midia m = app.getMidiaEspecifica(id);

                    if (m != null) {
                        System.out.println("Audiência registrada");
                        user.registrarAudiencia(m);
                    } else {
                        System.out.println("Essa mídia não foi encontrada");
                    }
                } catch (ClienteNaoProfissional e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println("Não foi possível assistir essa mídia.");
                    System.out.println(e);
                }
            } else if (opt == 7) {
                System.out.println("Digite o ID da mídia que deseja avaliar (Você precisa ter assistido ela antes):");

                try {
                    scanner.nextLine();
                    String id = scanner.nextLine();
                    Midia m = app.getMidiaEspecifica(id);

                    

                    if(m != null){                        
                        LocalDate diaAssistido = user.jaAssistiu(m);
                        if(diaAssistido != null){
                            float nota = -1;
                            while (true) {
                                System.out.println("Qual nota você deseja dar? 1 - 5");
                                try {
                                    nota = scanner.nextFloat();
                                } catch (Exception e) {
                                    // TODO: handle exception
                                    System.out.println("Valor inválido");
                                }

                                if (nota >= 0 && nota <= 5) {
                                    break;
                                } else {
                                    System.out.println("Valor inválido");
                                }
                            }

                            LocalDate diaAtual = LocalDate.now();
                            String desc = "";

                            
                            if(m.isLancamento()){
                                if(user instanceof clienteProfissional){
                                    System.out.println("Deixe um comentário, caso contrário deixe em branco.");
                                    scanner.nextLine();
                                    desc = scanner.nextLine();

                                    diaAtual = LocalDate.now();
                                    Avaliacao avaliacao = new Avaliacao(nota, desc, diaAtual.toString());

                                    clienteProfissional userProfissional = (clienteProfissional) user;
                                    userProfissional.avaliarMidia(m, avaliacao);
                                }
                                else{
                                    System.out.println("Somente poffisionais podem avaliar lançamentos");
                                }
                            }
                            else{
                                if(user instanceof clienteEspecialista){
                                System.out.println("Deixe um comentário, caso contrário deixe em branco.");
                                scanner.nextLine();
                                desc = scanner.nextLine();

                                diaAtual = LocalDate.now();
                                Avaliacao avaliacao = new Avaliacao(nota, desc, diaAtual.toString());

                                clienteEspecialista userProfissional = (clienteEspecialista) user;
                                userProfissional.avaliarMidia(m, avaliacao);
                                }
                                else if(user instanceof clienteProfissional){
                                    System.out.println("Deixe um comentário, caso contrário deixe em branco.");
                                    scanner.nextLine();
                                    desc = scanner.nextLine();

                                    diaAtual = LocalDate.now();
                                    Avaliacao avaliacao = new Avaliacao(nota, desc, diaAtual.toString());

                                    clienteProfissional userProfissional = (clienteProfissional) user;
                                    userProfissional.avaliarMidia(m, avaliacao);
                                }
                                else{
                                    diaAtual = LocalDate.now();
                                    Avaliacao avaliacao = new Avaliacao(nota, diaAtual.toString());

                                    clienteComum clienteComum = (clienteComum) user;
                                    clienteComum.avaliarMidia(m, avaliacao); 
                                }
                            }
                            
                            System.out.println("Avaliação feita com sucesso.");

                            try {
                                FileWriter fileWriter = new FileWriter("avaliacoes.txt", true);
                                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                                bufferedWriter.newLine();
                                bufferedWriter.write(user.getLogin() + ";" + m.getId() + ";" + nota + ";" + desc + ";"
                                        + diaAtual.toString());

                                bufferedWriter.close();
                            } catch (IOException e) {
                                System.out
                                        .println("Ocorreu um erro ao adicionar conteúdo ao arquivo: " + e.getMessage());
                            }
                        } else {
                            System.out.println(
                                    "Você não assistiu ainda essa mídia, tente assisti-lá para depois fazer sua avaliação");
                        }
                    } else {
                        System.out.println("Essa mídia não foi encontrada");
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else if (opt == 8) {
                // minhas avalicações
                try {
                    user.getListaJaVista().forEach((key, value) -> {
                        key.getNotas().forEach((keyNota, valueNota) -> {
                            if (keyNota.getLogin() == user.getLogin()) {
                                System.out.println("Mídia: " + key.getNome());
                                System.out.println(valueNota.toString());
                            }
                        });
                    });
                } catch (Exception e) {
                    System.out.println("Não foi possível buscar suas avaliações");
                    System.out.println(e);
                }

            }else if (opt == 9){
                try{
                   System.out.println(app.top10MidiasMelhorAvaliacao());
                }catch(Exception e) {
                    System.out.println("Não foi possível buscar suas avaliações");
                    System.out.println(e);
                }
            } else if (opt == 10){
                try{
                   System.out.println(app.top10MidiasMelhorAvaliacaoSeparadaPorGenero());
                }catch(Exception e) {
                    System.out.println("Não foi possível buscar suas avaliações");
                    System.out.println(e);
                }
            }else if (opt == 11){
                try{
                   System.out.println(app.top10MidiasMaisVisualizacaoSeparadaPorGenero());
                }catch(Exception e) {
                    System.out.println("Não foi possível buscar suas avaliações");
                    System.out.println(e);
                }
            }
            else if (opt == 12){
                try{
                    Map<Integer, Cliente> resp = app.clienteMaisAssistiuMidiasNumMidias();
                   for (Map.Entry<Integer, Cliente> entry : resp.entrySet()) {
                         Integer quantidadeMidias = entry.getKey();
                         Cliente cliente = entry.getValue();
                         System.out.println("Cliente: " + cliente);
                         System.out.println("Quantidade de mídias assistidas: " + quantidadeMidias);
                   }
                }catch(Exception e) {
                    System.out.println("Não foi possível buscar suas avaliações");
                    System.out.println(e);
                }
            }
            
            else if (opt == 0) {
                break;
            } else {
                System.out.println("Opção inválida");
            }
        }

        return;
    }
}

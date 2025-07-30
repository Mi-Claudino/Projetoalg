import java.util.Scanner;

public class JogoIrado {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String local = zLocais.COMECO;
        boolean jogando = true;

        System.out.print(
    ".-----------------------------------------------------------------.\n" +
    "|  ____                                                  _        |\n" +
    "| / ___| __ _ __   __ ___  _ __  _ __    __ _  ___    __| |  ___  |\n" +
    "| |    / _` |\\ \\ / // _ \\| '__|| '_ \\  / _` |/ __|  / _` | / _ \\ |\n" +
    "| |___| (_| | \\ V /|  __/| |   | | | || (_| |\\__ \\ | (_| ||  __/ |\n" +
    "| \\____|\\__,_|  \\_/  \\___||_|   |_| |_|\\__,_||___/  \\__,_| \\___| |\n" +
    "|              ____               _                               |\n" +
    "|             / ___|  ___   _ __ ( ) __ _   ___                   |\n" +
    "|            | |  _  / _ \\ | '__||/ / _` | / _ \\                  |\n" +
    "|            | |_| || (_) || |     | (_| || (_) |                 |\n" +
    "|             \\____| \\___/ |_|      \\__, | \\___/                  |\n" +
    "|                                   |___/                         |\n" +
    "'-----------------------------------------------------------------'");
        
        System.out.println(
            "\nCavernas de Gor'go \n\n" +
            "2025 - Mi Claudino - Pensamento computacional e algoritmos\n" + "\n" + "\n");
        System.out.println("No meio da densa floresta de Lukandor existe uma profunda caverna, no final dela há um grande tesouro guardado pelo Orc Gor'go.\n" +
            "Você é Dorros, um guerreiro da cidade de Lunkador que decidiu explorar a caverna com amigos no seu aniversário, em busca do sonhado tesouro.\n"+
            "Depois de inesperadamente escorregar, você acorda perdido na caverna. Ao se levantar, percebe que se encontra sozinho. \n" + "\n" +
            "Olhando ao seu redor você encontra o seu lampião no chão.");

        while (jogando) {
            switch (local) {
                case zLocais.COMECO:
                    System.out.println("Você encontra uma grande subida que brilha com um pouco de luz.\n" +
                    "Há também uma entrada escura que vai para mais fundo na caverna. \n" +
                    "\nO que deseja fazer?\n");
                    System.out.println("1. Subir pela entrada iluminada");
                    System.out.println("2. Ir para o fundo da caverna");
                    if (!zItems.temLampiao)
                        System.out.println("3. Pegar o lampião");
                    System.out.println("0. Sair do jogo");

                    int opcComeco = scanner.nextInt(); scanner.nextLine();
                    if (opcComeco == 1) {
                        if (zItems.temCordaComGancho) {
                                System.out.println("\nAcovardado, sem saber de seus amigos e sem o grande tesouro de Gor'go, você decide fugir da caverna, você passa o resto do seus dias\n" +
                                "pensando no que poderia ter feito se tivesse mais coragem, se tentansse entender como passar daquele espelho, o que aconteceria se você tentasse enfrentar gor'go. \n\n" +
                                "FINAL RUIM: Fuga da caverna.");
                            jogando = false;
                        } else {
                            System.out.println("\nA subida parece díficil e estreita, você sabe que apenas com os equipamentos corretos vai conseguir subir aqui.\n");
                        }
                    } else if (opcComeco == 2) {
                        if (zItems.temLampiao)
                            local = zLocais.CRUZAMENTO;
                        else
                            System.out.println("\nO caminho a frente é escuro e assustador, você não tem coragem para prosseguir desse jeito.\n");
                    } else if (opcComeco == 3 && !zItems.temLampiao) {
                        zItems.temLampiao = true;
                        System.out.println("\nSeu confiável lampião, com ele o caminho a frente não parece tão assustador, você o acende e o empunha.\n");
                    } else if (opcComeco == 0) {
                        System.out.println("Você abandonou a aventura.");
                        jogando = false;
                    }
                    break;

                case zLocais.CRUZAMENTO:
                    System.out.println("\nDesbravando os fundos da caverna de Gor'go você se sente confiante, mas o caminho pela frente parece complexo e perigoso\n" +
                    "Na sua frente uma grande entrada, e um barulho assustador parece vir deste corredor, o temível Gor'go\nJá a sua esquerda a uma outra entrada menor, te parece mais tranquila do que a grande entrada\n" +
                    "Um pouco escuro e escondindo, na direita tem um buraco que com um pouco de esforço você deve conseguir passar\nAonde você deseja ir?\n");
                    System.out.println("1. Grande caminho do meio");
                    System.out.println("2. Caminho mais normal à esquerda");
                    System.out.println("3. Caminho apertado à direita");
                    System.out.println("4. Voltar para a entrada");

                    int opcCruz = scanner.nextInt(); scanner.nextLine();
                    if (opcCruz == 1)
                        local = zLocais.ANTES_DO_ORC;
                    else if (opcCruz == 2)
                        local = zLocais.SALA_ESPELHO;
                    else if (opcCruz == 3)
                        local = zLocais.SUBIDA_DESCIDA;
                    else if (opcCruz == 4)
                        local = zLocais.COMECO;
                    break;

case zLocais.SALA_ESPELHO:
    System.out.println("\nUma sala oval quase aconchegante naquela sinuosa caverna está diante de seus olhos, algo inesperado está a sua frente, um espelho\nAo lado, perto de outra entrada você vê a jaqueta do seu amigo lenhador Glarbo, será que ele foi para aquela sala?\n" +
    "O que deseja fazer?\n");
    System.out.println("1. Olhar para o espelho misterioso");
    System.out.println("2. Ir para a sala perto da jaqueta de Glarbo");
    System.out.println("3. Voltar para a sala principal da caverna");

    int opcEsp = scanner.nextInt(); scanner.nextLine();
    if (opcEsp == 1) {
        if (zItems.espelhoQuebrado) {
            System.out.println("O espelho está quebrado!");
        } else if (zItems.temEspada) {
            System.out.println("'Tenha confiança, derrote Gar'go'");
        } else if (zItems.tentativasEspelho >= 2) {
            System.out.println("O espelho está quebrado!");
            zItems.espelhoQuebrado = true;
        } else {
            int acertos = 0;
            System.out.println("\nSeu reflexo começa a te encarar, após alguns segundos seu coração quase sai boca quando o seu reflexo começa a falar com você. \n" +
            "'Dorros você tem confiança em si mesmo? Me mostre que se importa com seus amigos e lhe darei a força para derrotar Gor'go. Responda minhas perguntas e lhe darei o que deseja.'\n" +
            "\nPergunta 1: O seu amigo lenhador, qual é seu nome?\n");
            if (scanner.nextLine().equalsIgnoreCase("Glarbo")) acertos++;
            System.out.println("\nPergunta 2: Qual o nome do seu esguio amigo que trouxe o equipamento de escalada?");
            if (scanner.nextLine().equalsIgnoreCase("Antonidas")) acertos++;
            System.out.println("\nPergunta 3: De qual cidade você veio?");
            if (scanner.nextLine().equalsIgnoreCase("Lukandor")) acertos++;
            if (acertos == 3) {
                zItems.temEspada = true;
                System.out.println("\nDorros, pegue isto e derrote aquele monstro.\n"+ 
                "Após as palavras de você mesmo, aquele espelho se abre como uma porta, lá dentro, enfincada em uma pedra, uma espada adornada com pedras brilhantes,\n'isso deve ser o suficiente para derrotar Gor'go' você fala para si mesmo enquanto pega a espada.");
            } else {
                zItems.tentativasEspelho++;
                if (zItems.tentativasEspelho >= 2) {
                    System.out.println("'Dorros, você não passa de um idiota!'\n" +
                    "Após as desmotivadoras palavras de si mesmo, o vidro do espelho se destroí completamente, a sua reflexão desaparece e agora é impossível descobrir os segredos do espelho.");
                    zItems.espelhoQuebrado = true;
                } else {
                    System.out.println("O vidro se racha na sua frente te assustando, parece que não vai aguentar muito tempo desse jeito, mas seu reflexo ainda está te encarando.\n" +
                    "'Dorros, você é melhor do que isso, se você nem ao menos sabe de si mesmo, como vai saber o que fazer contra Gor'go?'");
                }
            }
        }
    } else if (opcEsp == 2) {
        local = zLocais.SALA_FACAO;
    } else {
        local = zLocais.CRUZAMENTO;
    }
    break;
                case zLocais.SALA_FACAO:
                    System.out.println("\nVocê entra na sala com esperança de encontrar Glarbo, infelizmente você não o encontra.\n" +
                    "Mesmo desanimado você explora a sala, e por sorte, encontra a mochila de Glarbo. Dentro dela não tem muita coisa, apenas algumas rações de comida e... Um facão! 'isso pode ser útil'");
                    if (!zItems.temFacao) {
                        System.out.println("1. Pegar o facão");
                        System.out.println("2. Voltar");
                        int opcF = scanner.nextInt(); scanner.nextLine();
                        if (opcF == 1) {
                            zItems.temFacao = true;
                            System.out.println("\nVocê pegou o facão! Talvez não seja a melhor arma contra Gar'go, mas pode ser útil.");
                        } else {
                            local = zLocais.SALA_ESPELHO;
                        }
                    } else {
                        System.out.println("1. Voltar para a sala com o espelho");
                        scanner.nextInt(); scanner.nextLine();
                        local = zLocais.SALA_ESPELHO;
                    }
                    break;

                case zLocais.SUBIDA_DESCIDA:
                    System.out.println("\nVocê fica de bruços e se aperta por aquela apertada entrada, no meio do caminho você encontra algo familiar\n" +
                    "O colar de Antonidas, seu esguio amigo de Lunkador, 'sera que ele está ai pela frente?'\nDepois de mais um tempo rastejando, com dificuldade você chega a uma encruzilhada.\n"+
                    "Acima, o caminho se abre confortavelmente, já abaixo, grossas teias de aranha se formam. Por onde deseja prosseguir?\n");
                    System.out.println("1. Caminho aberto acima");
                    System.out.println("2. Caminho com teias de aranha abaixo");
                    System.out.println("3. Voltar para a sala principal da caverna");
                    int opcSD = scanner.nextInt(); scanner.nextLine();
                    if (opcSD == 1) local = zLocais.SALA_CORDA;
                    else if (opcSD == 2) local = zLocais.SALA_GANCHO;
                    else local = zLocais.CRUZAMENTO;
                    break;

                case zLocais.SALA_CORDA:
                    System.out.println("\nEntrando na sala, nenhum sinal de seu amigo por ali, mas com um pouco mais de exploração você se depara, em um canto, cheio de teias de aranha em volta, uma pequena bolsa\n" +
                    "'Essas são as coisas de Antonidas! Eu tenho certeza que ele trouxe uma corda, ele sempre foi o mais preparado de nós'. E lá estava, uma linda corda de escalada. no meio de seus manuais e rações." +
                    "O que deseja fazer?");
                    if (!zItems.temCorda) {
                        System.out.println("1. Pegar corda de Antonidas");
                        System.out.println("2. Voltar para a encruzilhada das aranhas");
                        int opcC = scanner.nextInt(); scanner.nextLine();
                        if (opcC == 1) {
                            zItems.temCorda = true;
                            System.out.println("Você pegou a corda! 'Se eu conseguir combinar com algum tipo de âncora eu devo conseguir sair daqui'");
                                if (zItems.temGancho && !zItems.temCordaComGancho) {
                                zItems.temCordaComGancho = true;
                                System.out.println("'Ah é verdade, aquele gancho que encontrei no meio das velharias faria uma ótima ferramente para ir embora.' Você combina a corda com o gancho.");
                            }
                        } else {
                            local = zLocais.SUBIDA_DESCIDA;
                        }
                    } else {
                        System.out.println("1. Voltar para a encruzilhada das aranhas");
                        scanner.nextInt(); scanner.nextLine();
                        local = zLocais.SUBIDA_DESCIDA;
                    }
                    break;

                case zLocais.SALA_GANCHO:
                    if (!zItems.temFacao) {
                        System.out.println("\nQuanto mais para baixo você avança, mais teias de aranha vão aparecendo, sem uma ferramenta para lidar com elas, o caminho será díficil");
                        System.out.println("1. Forçar passagem entre as teias");
                        System.out.println("2. Voltar para a encruzilhada");
                        int opcG = scanner.nextInt(); scanner.nextLine();
                        if (opcG == 1) {
                            System.out.println("As teias te prendem! Final ruim.");
                            jogando = false;
                        } else {
                            local = zLocais.SUBIDA_DESCIDA;
                        }
                    } else {
                        System.out.println("\nQuanto mais para baixo você avança, mais teias de aranha vão aparecendo, mas com o facão, passar por ali é muito mais fácil\n"+
                        "Depois de rastejar por um bom tempo você finalmente chega, uma sala lotada de pequenas aranhas, nenhum sinal de nenhum pertence de Antonidas\n"+
                        "Um pouco desanimado, você ainda acha que é uma boa ideia vasculhar aquela sala, e você encontra pertences muito mais antigos.\n"+
                        "Dentro das velharias, você encontra duas coisas que parecem do seu interesse, um velho pergaminho, e um velho gancho de escalada");
                        if (!zItems.temPergaminho) System.out.println("1. Pegar e ler o pergaminho");
                        if (!zItems.temGancho) System.out.println("2. Pegar o velho gancho");
                        System.out.println("3. Voltar para a encruzilhada das aranhas");
                        int opcG2 = scanner.nextInt(); scanner.nextLine();
                        if (opcG2 == 1 && !zItems.temPergaminho) {
                            zItems.temPergaminho = true;
                            System.out.println("Você pega o pergaminho em suas mãos, ao abri-lo você se surpreende, aquele documento de ter mais de 100 anos, 'como que isso foi parar aqui?'\n"+
                            "Mesmo em um lugar bastante perigoso, sua curiosidade é maior que seu juízo, você lê o pergaminho inteiro \n"+
                            "Dentro de muitas informações sobre as cavernas de Lukandor em um geral, algo te interessa muito mais do que o resto, uma fraquesa de Gor'go!\n" +
                            "'Gor'go é implacável, mas não invencível, sua fraqueza é a luz, achamos que é por isso que ele se separou da horda de orcs e veio para aqui'");
                        } else if (opcG2 == 2 && !zItems.temGancho) {
                            zItems.temGancho = true;
                            System.out.println("Você pegou o gancho! 'Se eu conseguir combinar com algum tipo de corda eu devo conseguir sair daqui'");
                            if (zItems.temCorda && !zItems.temCordaComGancho) {
                                zItems.temCordaComGancho = true;
                                System.out.println("'Ah é verdade, a corda de Antonidas que encontrei faria uma ótima ferramente para ir embora.' Você combina a corda com o gancho.");
                            }
                        } else {
                            local = zLocais.SUBIDA_DESCIDA;
                        }
                    }
                    break;

                case zLocais.ANTES_DO_ORC:
                    if (!zItems.temFacao && !zItems.temEspada) {
                        System.out.println("\nRugidos ensurdecedores te surpreendem, sem algo para se defender não existe possibilidade de entrar na sala do grande Orc Gor'go");
                        local = zLocais.CRUZAMENTO;
                    } else {
                        System.out.println("\nVocê ouve o Orc rugindo. Deseja continuar?");
                        System.out.println("1. Sim");
                        System.out.println("2. Voltar");
                        int opcA = scanner.nextInt(); scanner.nextLine();
                        if (opcA == 1) local = zLocais.SALA_ORC;
                        else local = zLocais.CRUZAMENTO;
                    }
                    break;

                case zLocais.SALA_ORC:
    System.out.println("\nVocê vai pra direção de Gor'go");

    if (zItems.temEspada) {
        // FASE 1
        System.out.println("O monstro ruge e olha para você, sem muito esperar desfere um ataque cego na sua direção, 'agora não é hora de se acovardar, ele está cego de raiva!'\n O que você faz?");
        System.out.println("1. Contra-atacar\n2. Desviar\n3. Fugir do confronto");
        int fase1 = scanner.nextInt(); scanner.nextLine();

        if (fase1 == 3) {
            System.out.println("Com medo você decide fugir da batalha e volta para o grande salão. Decepcionado com sigo mesmo você pensa no que pode fazer para prosseguir, mas perdido nos seus pensamentos você não percebe\n" +
            "Você olha para frente e vê a sombra do monstro que não teve coragem de combater, Gar'go está vindo furioso e você não tem pra onde correr.\nFINAL RUIM: Desistiu da batalha mas a batalha não desistiu de você.");
            jogando = false;
            break;
        }

        boolean fase1Correta = (fase1 == 1);

        // FASE 2
        System.out.println("A batalha é feroz, quem vai levar a melhor, Gor'go está absolutamente furioso!\n O que deseja fazer?");
        System.out.println("1. Atacar\n2. Desviar\n");
            if (zItems.temPergaminho) { 
            System.out.println("3. Seguir instruções do pergaminho e cegar o monstro com seu lampião!\n"); 
        } 
        int fase2 = scanner.nextInt(); scanner.nextLine();

        boolean fase2Correta = (fase2 == 3 && zItems.temPergaminho);

        // FASE 3
        System.out.println("É o momento decisivo, todos os momentos naquela apertada caverna encontram seu apíce aqui, qual é sua ultima decisão contra o monstro!");
        System.out.println("1. Atacar\n2. Desviar\n3. Fugir\n");
        int fase3 = scanner.nextInt(); scanner.nextLine();

        if (fase3 == 3) {
            System.out.println("Com medo você decide fugir logo no final da batalha e volta para o grande salão. Decepcionado com sigo mesmo você pensa no que pode fazer para prosseguir, mas perdido nos seus pensamentos você não percebe\n" +
            "Você olha para frente e vê a sombra do monstro que não teve coragem de combater, Gar'go está vindo furioso e você não tem pra onde correr.\nFINAL RUIM: Desistiu da batalha mas a batalha não desistiu de você.");
            jogando = false;
            break;
        }

        boolean fase3Correta = (fase3 == 1);

        if (fase1Correta && fase2Correta && fase3Correta) {
            System.out.println("As suas decisões parecem perfeitas, você lê os movimentos do Orc como um livro, e os ensinamentos do pergaminho são infalíveis, o Orc, cego após você apontar a cegante luz em sua direção decide tentar seu último e fatal ataque\n"+
            "Mas você é Dorros de Lunkador, nada pode te derrotar. Você enfinca a espada no monstro e jatos de sangue se espirram para todos os lados");
            System.out.println("Vitória! Você vence Gor'go! Depois de respirar um pouco você repara, atrás do, agora derrotado orc, se tem um pequeno baú. Nele um pequeno medalhão, e uma carta:\n" +
            "O medalhão da sacerdotiza de Lunkador, artefato sagrado que trás de volta a vida as pessoas mais amadas de seu empunhador, tudo que ele deve fazer é falar seus nomes na catedral central de Lunkador.\n" +
            "'Espera, com isso, se meus amigos morreram nessa caverna, eu conseguirei salva-los'\nDepois de sair da caverna, você volta para a cidade de Lunkador, vai na catedral e fala os nomes 'Glarbo' e 'Antonidas'\n"+
            "Como magica, seus amigos se materializam na sua frente. 'AMIGOS! Aonde vocês foram parar depois de eu desmaiei?'\n'Eu virei janta de Orc HAHAHA!' Responde Glarbo com um sombrio entusiamo classico de seu bruto amigo.\n" +
            "'Já eu fui levado por uma aranha gigantesca! A gente nunca mais vai comemorar um aniversário em cavernas!' Responde o assustado e esguio Antonidas\n" +
            "Depois de um pouco de papo furado e lágrimas vocês decidem ir na taverna aproveitar o final de seu memorável aniversário.\n" +
            "FINAL VERDADEIRO: O campeão de Lunkandor");
        } else {
            System.out.println("Mesmo com a espada e muita confiança Gor'go é implacável, a batalha é furiosa e você parecia ter chance de ganhar, infelizmente o Orc não desiste em momento algum!\n" +
            "Já cansado, Gar'go joga seu corpo em cima do seu, desferindo seu ultimo e fatal ataque! Você vê os olhos de Gar'go perdendo a vida se enficando na sua espada, mas o peso do monstro cai sobre você!\nFINAL RUIM: Ambos derrotados.");
        }

    } else {
        System.out.println("Você entra na sala do grandiogo Gor'go, o monstro ruge e lança seus olhos na sua direção, com seu facão e seu lampião na mão você corre em direção ao monstro.\n" +
        "O orc tenta te atacar mas você é o corajoso Dorros, o que pode dar de errado? Você o atinge na coxa. \nInesperadamente o monstro não parece esboçar muita reação, o corte não teve efeito!\n" +
        "'COMO ESSA CRIATURA PODE SER DERROTADA?' Você suplica, mas já é tarde de mais, mesmo com bravura, você é derrotado pelo Orc.\nFINAL RUIM: A queda do herói");
    }
    jogando = false;
    break;
            }
        }
        scanner.close();
        System.out.println("Obrigado por jogar!");
    }
}
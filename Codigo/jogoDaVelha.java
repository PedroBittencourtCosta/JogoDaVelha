//JOGO DA VELHA
//PRÁTICA DE PROGRAMAÇÃO
//PROFESSOR: HIGOR DELFINO
//ALUNOS: LAURA ARANTES, LEONE VAZ, PEDRO BITTENCOURT, WAGNER FILHO, YAGHO ZACARIAS
import java.util.Scanner;
import java.io.IOException;

class jogoDaVelha{
	public static void main(String[] args) throws IOException, InterruptedException{
		
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		
		Scanner sc = new Scanner(System.in);
		
		// Declaracao de variaveis:
		String vazio = " ", vencedor = " ", j1=" ", j2=" ", nomeJogador=" ", letra= "Digite apenas números!", numerosInvalidos="Valores maiores ou menores do que 3! Digite novamente: "; 
		String cheio = " lugar ocupado", erro = "Valores inválidos! Digite novamente:", velha = "Deu velha!!!!!";
		String mensagem = " ", a11=" ", a12=" ", a13=" ", a21=" ", a22=" ", a23=" ", a31=" ", a32=" ", a33=" ";
		int numL = 0, numC = 0, jogada = 1, jogadorI = 1, jogadorII = 2;
		boolean game = true;
		
		
		System.out.println("");	
		System.out.println("#JOGO DA VELHA#");
		System.out.print("Insira o nome do JOGADOR 1: ");
		j1 = sc.nextLine();
		System.out.print("Insira o nome do JOGADOR 2: ");
		j2 = sc.nextLine();

		nomeJogador=j1;

		do
		{

			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			
            System.out.printf("\nMensagem: %s", mensagem);
            System.out.print("\n   "+a11+"| "+a12+"| "+a13+"");
            System.out.print("\n1 __|__|__");
            System.out.print("\n   "+a21+"| "+a22+"| "+a23+"");
            System.out.print("\n2 __|__|__");
            System.out.print("\n   "+a31+"| "+a32+"| "+a33+"");
            System.out.print("\n3   |  |  ");
            System.out.print("\n  1   2   3");
			
			System.out.println();
            System.out.println("Jogador " + jogada + " ("+nomeJogador+")");

			System.out.print("Digite o número da linha: ");
			try{
				
				numL = sc.nextInt();
				
			}catch(Exception ex){
				
				sc.nextLine();
				mensagem = letra;
				
			}
			
			System.out.print("Digite o número da coluna: ");
			
			try{
				
				numC = sc.nextInt();
			
			}catch(Exception ex2){
				
				sc.nextLine();
				mensagem = letra;
				
			}

			while((numL<1 || numL>3)||(numC<1 || numC>3)) //correção de número maiores que 3 ou menores que 1
			{
				mensagem = erro;
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
				System.out.printf("\nMensagem: %s", mensagem);
				System.out.print("\n   "+a11+"| "+a12+"| "+a13+"");
				System.out.print("\n1 __|__|__");
				System.out.print("\n   "+a21+"| "+a22+"| "+a23+"");
				System.out.print("\n2 __|__|__");
				System.out.print("\n   "+a31+"| "+a32+"| "+a33+"");
				System.out.print("\n3   |  |  ");
				System.out.print("\n  1   2   3");
				
				System.out.println();
				System.out.println("Jogador " + jogada + " ("+nomeJogador+")");

				System.out.print("Digite o número da linha: ");
				try{
					
					numL = sc.nextInt();
					
				}catch(Exception ex){
					
					sc.nextLine();
					mensagem = letra;
					
				}
				
				System.out.print("Digite o número da coluna: ");
				
				try{
					
					numC = sc.nextInt();
				
				}catch(Exception ex2){
					
					sc.nextLine();
					mensagem = letra;
					
				}
			}

				// mensagem = " ";
			
			//
			//Aqui farei a parte que analisa o vencedor e dá fim ao looping principal.
			// a11  a12  a13
			// a21  a22  a23
			// a31  a32  a33
			
			if //Esse if analisará as possibilidades do jogador 1 (X) ser o vencedor.
			(
				((a11 == "X") && (a12 == "X") && (a13 == "X")) || //Vencedor X na linha 1
				((a21 == "X") && (a22 == "X") && (a23 == "X")) || //Vencedor X na linha 2
				((a31 == "X") && (a32 == "X") && (a33 == "X")) || //Vencedor X na linha 3

				((a11 == "X") && (a21 == "X") && (a31 == "X")) || //Vencedor X na coluna 1
				((a12 == "X") && (a22 == "X") && (a32 == "X")) || //Vencedor X na coluna 2
				((a13 == "X") && (a23 == "X") && (a33 == "X")) || //Vencedor X na coluna 2

				((a11 == "X") && (a22 == "X") && (a33 == "X")) || //Vencedor X na diagonal a11 -> a33
				((a31 == "X") && (a22 == "X") && (a13 == "X"))	  //Vencedor X na diagonal a31 -> a13
			)
			{
				vencedor = j1;
				game = false;
				break;
			}
			else if //Esse if analisará as possibilidades do jogador 2 (O) ser o vencedor.
			(
				((a11 == "O") && (a12 == "O") && (a13 == "O")) || //Vencedor O na linha 1
				((a21 == "O") && (a22 == "O") && (a23 == "O")) || //Vencedor O na linha 2
				((a31 == "O") && (a32 == "O") && (a33 == "O")) || //Vencedor O na linha 3

				((a11 == "O") && (a21 == "O") && (a31 == "O")) || //Vencedor O na coluna 1
				((a12 == "O") && (a22 == "O") && (a32 == "O")) || //Vencedor O na coluna 2
				((a13 == "O") && (a23 == "O") && (a33 == "O")) || //Vencedor O na coluna 2

				((a11 == "O") && (a22 == "O") && (a33 == "O")) || //Vencedor O na diagonal a11 -> a33
				((a31 == "O") && (a22 == "O") && (a13 == "O"))	  //Vencedor O na diagonal a31 -> a13				
			)
			{
				vencedor = j2;
				game = false;
				break;			
			}
			else if //Se todas as casas estiverem ocupadas, declara velha;
			(
				(a11 !=" ") && (a12 !=" ") && (a13 !=" ") &&
				(a21 !=" ") && (a22 !=" ") && (a23 !=" ") &&
				((a31 !=" ") && (a32 !=" ") && (a33 !=" "))
			)
			{
				mensagem = velha;
				game = false;
				break;
			}
			//Esse parte precisará ser repetido mais duas vezes ao longo do código.
			//

			while(jogada != 0){
				
				if(jogada == 1 && numL == 1 && numC == 1){
					if(a11 !=" "){   
						mensagem = cheio;
						nomeJogador = j1;
						break;
					}else{
						a11 = "X";
						jogada = jogadorII;
						nomeJogador = j2;
						mensagem = vazio;
						numC = 0;
						numL = 0;
						break;						
					}
				}else if(jogada == 1 && numL == 1 && numC == 2){
						if(a12 !=" "){
							mensagem = cheio;
							nomeJogador = j1;
							break;
						}else{
							a12 = "X";
							jogada = jogadorII;
							nomeJogador = j2;
							mensagem = vazio;
							numC = 0;
							numL = 0;
							break;							
						}
				}else if(jogada == 1 && numL == 1 && numC == 3){
						if(a13 !=" "){
							mensagem = cheio;
							nomeJogador = j1;
							break;
						}else{
							a13 = "X";
							jogada = jogadorII;
							nomeJogador = j2;
							mensagem = vazio;
							numC = 0;
							numL = 0;
							break;							
						}
				}else if(jogada == 1 && numL == 2 && numC == 1){
						if(a21 !=" "){
							mensagem = cheio;
							nomeJogador = j1;
							break;
						}else{
							a21 = "X";
							jogada = jogadorII;
							nomeJogador = j2;
							mensagem = vazio;
							numC = 0;
							numL = 0;
							break;							
						}
				}else if(jogada == 1 && numL == 2 && numC == 2){
						if(a22 !=" "){
							mensagem = cheio;
							nomeJogador = j1;
							break;
						}else{
							a22 = "X";
							jogada = jogadorII;
							nomeJogador = j2;
							mensagem = vazio;
							numC = 0;
							numL = 0;
							break;							
						}
				}else if(jogada == 1 && numL == 2 && numC == 3){
						if(a23 !=" "){
							mensagem = cheio;
							nomeJogador = j1;
							break;
						}else{
							a23 = "X";
							jogada = jogadorII;
							nomeJogador = j2;
							mensagem = vazio;
							numC = 0;
							numL = 0;
							break;							
						}
				}else if(jogada == 1 && numL == 3 && numC == 1){
						if(a31 !=" "){
							 mensagem = cheio;
							nomeJogador = j1;
							break;
						}else{
							a31 = "X";
							jogada = jogadorII;
							nomeJogador = j2;
							mensagem = vazio;
							numC = 0;
							numL = 0;
							break;						
						}
				}else if(jogada == 1 && numL == 3 && numC == 2){
						if(a32 !=" "){
							mensagem = cheio;
							nomeJogador = j1;
							break;
						}else{
							a32 = "X";
							jogada = jogadorII;
							nomeJogador = j2;
							mensagem = vazio;
							numC = 0;
							numL = 0;
							break;							
						}
				}else if(jogada == 1 && numL == 3 && numC == 3){
						if(a33 !=" "){
							mensagem = cheio;
							nomeJogador = j1;
							break;
						}else{
							a33 = "X";
							jogada = jogadorII;
							nomeJogador = j2;
							mensagem = vazio;
							numC = 0;
							numL = 0;
							break;						
						}
				}
				break;
			}
			//
			//SEGUNDA ANÁLISE DE VENCEDOR
			if //Esse if analisará as possibilidades do jogador 1 (X) ser o vencedor.
			(
				((a11 == "X") && (a12 == "X") && (a13 == "X")) || //Vencedor X na linha 1
				((a21 == "X") && (a22 == "X") && (a23 == "X")) || //Vencedor X na linha 2
				((a31 == "X") && (a32 == "X") && (a33 == "X")) || //Vencedor X na linha 3

				((a11 == "X") && (a21 == "X") && (a31 == "X")) || //Vencedor X na coluna 1
				((a12 == "X") && (a22 == "X") && (a32 == "X")) || //Vencedor X na coluna 2
				((a13 == "X") && (a23 == "X") && (a33 == "X")) || //Vencedor X na coluna 2

				((a11 == "X") && (a22 == "X") && (a33 == "X")) || //Vencedor X na diagonal a11 -> a33
				((a31 == "X") && (a22 == "X") && (a13 == "X"))	  //Vencedor X na diagonal a31 -> a13
			)
			{
				vencedor = j1;
				game = false;
				break;
			}
			else if //Esse if analisará as possibilidades do jogador 2 (O) ser o vencedor.
			(
				((a11 == "O") && (a12 == "O") && (a13 == "O")) || //Vencedor O na linha 1
				((a21 == "O") && (a22 == "O") && (a23 == "O")) || //Vencedor O na linha 2
				((a31 == "O") && (a32 == "O") && (a33 == "O")) || //Vencedor O na linha 3

				((a11 == "O") && (a21 == "O") && (a31 == "O")) || //Vencedor O na coluna 1
				((a12 == "O") && (a22 == "O") && (a32 == "O")) || //Vencedor O na coluna 2
				((a13 == "O") && (a23 == "O") && (a33 == "O")) || //Vencedor O na coluna 2

				((a11 == "O") && (a22 == "O") && (a33 == "O")) || //Vencedor O na diagonal a11 -> a33
				((a31 == "O") && (a22 == "O") && (a13 == "O"))	  //Vencedor O na diagonal a31 -> a13				
			)
			{
				vencedor = j2;
				game = false;
				break;				
			}
			else if //Se todas as casas estiverem ocupadas, declara velha;
			(
				(a11 !=" ") && (a12 !=" ") && (a13 !=" ") &&
				(a21 !=" ") && (a22 !=" ") && (a23 !=" ") &&
				((a31 !=" ") && (a32 !=" ") && (a33 !=" "))
			)
			{
				mensagem = velha;
				game = false;
				break;
			}
			//

			if(jogada==2)
			{
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
				System.out.printf("\nMensagem: %s", mensagem);
				System.out.print("\n   "+a11+"| "+a12+"| "+a13+"");
				System.out.print("\n1 __|__|__");
				System.out.print("\n   "+a21+"| "+a22+"| "+a23+"");
				System.out.print("\n2 __|__|__");
				System.out.print("\n   "+a31+"| "+a32+"| "+a33+"");
				System.out.print("\n3   |  |  ");
				System.out.print("\n  1   2   3");
				
			}

			while (jogada != 0){
					 
				if(jogada == 2 && numL == 1 && numC == 1){
					if(a11 !=" "){
						mensagem = cheio;
						nomeJogador = j2;
						break;
					}else{
						a11 = "O";
						jogada = jogadorI;
						nomeJogador = j1;
						mensagem = vazio;
						break;						
					}
				}else if(jogada == 2 && numL == 1 && numC == 2){
						if(a12 !=" "){
							
							nomeJogador = j2;
							mensagem = cheio; // errro
							break;
						}else{
							a12 = "O";
							jogada = jogadorI;
							nomeJogador = j1;
							mensagem = vazio;
							break;						
						}
				}else if(jogada == 2 && numL == 1 && numC == 3){
						if(a13 !=" "){
							mensagem = cheio;
							nomeJogador = j2;
							break;
						}else{
							a13 = "O";
							jogada = jogadorI;
							nomeJogador = j1;
							mensagem = vazio;
							break;							
						}
				}else if(jogada == 2 && numL == 2 && numC == 1){
						if(a21 !=" "){
							mensagem = cheio;
							nomeJogador = j2;
							break;
						}else{
							a21 = "O";
							jogada = jogadorI;
							nomeJogador = j1;
							mensagem = vazio;
							break;						
						}
				}else if(jogada == 2 && numL == 2 && numC == 2){
						if(a22 !=" "){
							mensagem = cheio ; // erro
							nomeJogador = j2;
							break;
						}else{
							a22 = "O";
							jogada = jogadorI;
							nomeJogador = j1;
							mensagem = vazio;
							break;						
						}
				}else if(jogada == 2 && numL == 2 && numC == 3){
						if(a23 !=" "){
							mensagem = cheio;
							nomeJogador = j2;
							break;
						}else{
							a23 = "O";
							jogada = jogadorI;
							nomeJogador = j1;
							mensagem = vazio;
							break;						
						}
				}else if(jogada == 2 && numL == 3 && numC == 1){
						if(a31 !=" "){
							mensagem = cheio;
							nomeJogador = j2;
							break;
						}else{
							a31 = "O";
							jogada = jogadorI;
							nomeJogador = j1;
							mensagem = vazio;
							break;					
						}
				}else if(jogada == 2 && numL == 3 && numC == 2){
						if(a32 !=" "){
							mensagem = cheio;
							nomeJogador = j2;
							break;
						}else{
							a32 = "O";
							jogada = jogadorI;
							nomeJogador = j1;
							mensagem = vazio;
							break;							
						}
				}else if(jogada == 2 && numL == 3 && numC == 3){
						if(a33 !=" "){
							mensagem =cheio;
							nomeJogador = j2;
							break;
						}else{
							a33 = "O";
							jogada = jogadorI;
							nomeJogador = j1;
							mensagem = vazio;
							break;							
						}
					
				}	
				break;
			}
			//
			//TERCEIRA ANÁLISE DE VENCEDOR
			if //Esse if analisará as possibilidades do jogador 1 (X) ser o vencedor.
			(
				((a11 == "X") && (a12 == "X") && (a13 == "X")) || //Vencedor X na linha 1
				((a21 == "X") && (a22 == "X") && (a23 == "X")) || //Vencedor X na linha 2
				((a31 == "X") && (a32 == "X") && (a33 == "X")) || //Vencedor X na linha 3

				((a11 == "X") && (a21 == "X") && (a31 == "X")) || //Vencedor X na coluna 1
				((a12 == "X") && (a22 == "X") && (a32 == "X")) || //Vencedor X na coluna 2
				((a13 == "X") && (a23 == "X") && (a33 == "X")) || //Vencedor X na coluna 3

				((a11 == "X") && (a22 == "X") && (a33 == "X")) || //Vencedor X na diagonal a11 -> a33
				((a31 == "X") && (a22 == "X") && (a13 == "X"))	  //Vencedor X na diagonal a31 -> a13
			)
			{
				vencedor = j1;
				game = false;
				break;
			}
			else if //Esse if analisará as possibilidades do jogador 2 (O) ser o vencedor.
			(
				((a11 == "O") && (a12 == "O") && (a13 == "O")) || //Vencedor O na linha 1
				((a21 == "O") && (a22 == "O") && (a23 == "O")) || //Vencedor O na linha 2
				((a31 == "O") && (a32 == "O") && (a33 == "O")) || //Vencedor O na linha 3

				((a11 == "O") && (a21 == "O") && (a31 == "O")) || //Vencedor O na coluna 1
				((a12 == "O") && (a22 == "O") && (a32 == "O")) || //Vencedor O na coluna 2
				((a13 == "O") && (a23 == "O") && (a33 == "O")) || //Vencedor O na coluna 3

				((a11 == "O") && (a22 == "O") && (a33 == "O")) || //Vencedor O na diagonal a11 -> a33
				((a31 == "O") && (a22 == "O") && (a13 == "O"))	  //Vencedor O na diagonal a31 -> a13				
			)
			{
				vencedor = j2;
				game = false;
				break;				
			}
			else if //Se todas as casas estiverem ocupadas, declara velha;
			(
				(a11 !=" ") && (a12 !=" ") && (a13 !=" ") &&
				(a21 !=" ") && (a22 !=" ") && (a23 !=" ") &&
				((a31 !=" ") && (a32 !=" ") && (a33 !=" "))
			)
			{
				mensagem = velha;
				game = false;
				break;
			}
			//



		}while(game);

		if(mensagem == velha)
		{
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			System.out.printf("\nMensagem: " + velha);
			System.out.print("\n   "+a11+"| "+a12+"| "+a13+"");
			System.out.print("\n1 __|__|__");
			System.out.print("\n   "+a21+"| "+a22+"| "+a23+"");
			System.out.print("\n2 __|__|__");
			System.out.print("\n   "+a31+"| "+a32+"| "+a33+"");
			System.out.print("\n3   |  |  ");
			System.out.println("\n  1   2   3");
			System.out.println("Deu velha!");
		}
		else
		{
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			System.out.printf("\nMensagem: " + "Fim de jogo!");
			System.out.print("\n   "+a11+"| "+a12+"| "+a13+"");
			System.out.print("\n1 __|__|__");
			System.out.print("\n   "+a21+"| "+a22+"| "+a23+"");
			System.out.print("\n2 __|__|__");
			System.out.print("\n   "+a31+"| "+a32+"| "+a33+"");
			System.out.print("\n3   |  |  ");
			System.out.println("\n  1   2   3");
			System.out.println("O vencedor é: " + vencedor);
		}
	}
}
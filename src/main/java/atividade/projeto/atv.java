package atividade.projeto;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class atv {
    
     public static String mensagem;
     public static List<String> frases;

	public static void main(String[] args) {
		SpringApplication.run(atv.class, args);

		try { 
            frases = new ArrayList<>();
            String url = "https://onepiece.fandom.com/pt/wiki/Skypiea";
            Document doc = Jsoup.connect(url).get();
            String texto =  doc.body().text(); 
            String frase = "povo de Skypiea";
            

            int contagemFrase = contarOcorrencias(texto, frase);
            frases.add(frase);
            System.out.println("A frase: " + "[" + frase + "]" + " foi encontrada " + contagemFrase + " vezes.");
            String frasecompl = "A frase: " + "[" + frase + "]" + " foi encontrada " + contagemFrase + " vezes.";
            frases.add(frasecompl);
            
            String[] palavras = frase.split("\\s+");
            
           
            for (String palavra : palavras) {
                int contagemPalavra = contarOcorrencias(texto, palavra);
				String palavracompl = "A palavra: " + "[" + palavra + "]" + " repete " + contagemPalavra + " Vezes." ;
                
                frases.add(palavracompl);
                
                service serv = new service();
				frases = serv.getMessage();
                System.out.println ("A palavra: " + "[" + palavra + "]" + " repete " + contagemPalavra + " Vezes."  );
               
            }

         } catch (Exception e) {
            System.err.println("Erro ao conectar a url: " + e.getMessage());
        } 
        
    }

    private static int contarOcorrencias(String texto, String subTexto) {
        int contagem = 0;
        String regex = "\\b" +  subTexto + "\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);

        while (matcher.find()) {
            contagem++;
        }
        return contagem;

	}

}

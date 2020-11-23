
# [](https://github.com/essofd/devmuch) Delivery Much - Automação de Teste de Software

Site Testado: Delivery Much: [Delivery Much](http://challengeqa.staging.devmuch.io/)

Donwload do projeto: [devmuch](https://github.com/essofd/devmuch/archive/master.zip).

Softwares necessários:
IDE: [Eclipse](http://www.eclipse.org/)
Java: [Java](http://www.oracle.com/technetwork/pt/java/index.html)
Maven: [Maven](https://maven.apache.org/download.cgi)

**Regras do Desafio**
1. Servidor HTTP que funcionará apenas para requisições GET;
2. Sistema permitirá utilizar apenas números no intervalo entre [-10000, 10000];
3. Ao se fazer essa requisição, retornará um JSON cuja chave "extenso" terá, em
seu valor, o número inteiro por extenso, que foi inserido na path;
4. Pensando-se na internacionalização deste, o serviço terá suporte, além de
portugues, para tambem em ingles;
5. Caso não seja possível converter o valor inserido na path, chave “extenso” terá
valor “Invalid data”;
6. Para estes casos, resposta deve ter status 400;
7. Para os casos válidos, resposta deve ter status 200.



**Preparação do ambiente - Passo a Passo:**
 1. Baixe e instale o Eclipse;
 2. Baixe e instale o Java: JRE e JDK;
 3. Baixe e descompacte o Maven;
 4. Configure o Java e o Maven no Windows 10: vá até o Painel de Controle > Sistema e Segurança > Sistema;
 5. Clique em "Configurações avançadas do sistema";
 6. Clique em "Variáveis de Ambiente...";
 7. Clique no botão “Nova” em “Variáveis do sistema”;
 8. Digite no nome da variável: "JAVA_HOME";
 9. No valor da variável: coloque o endereço onde foi instalado. Exemplo: “C:\Program Files\Java\jdk1.8.0_161”;
 10. Clique em "OK";
 11. Clique novamente no botão “Nova” em “Variáveis do sistema”;
 12. Digite no nome da variável: "MAVEN_HOME";
 13. No valor da variável: coloque o endereço onde foi instalado. Exemplo: “C:\Program Files\Maven\apache-maven-3.6.3”;
 14. Clique em "OK";
 15. Selecione "Path" e clique em "Editar...";
 16. Clique em "Novo" e digite "%JAVA_HOME%\bin";
 17. Clique em "Novo" novamente e digite "%MAVEN_HOME%\bin" e depois clique em "OK"
 18. Clique em "OK" novamente para salvar as configurações;
 19. Para confirmar se foi configurado certo e a verificar a versão:
            vá ao CMD(Prompt de comando) e digite: "java -version"
            e após isto no CMD digite: "mvn -version"

**Executando o script - Passo a Passo:**
 1. Baixe o projeto e descompacte-o;
 2. Acesse o Eclipse;
 3. Dentro do eclipse clique em "File" e depois em "Open Projects from File System...";
 4. Em Import source, digite o endereço do projeto. Exemplo: "C:\Repositorio\api-deliverymuch". Ou clique em "Directory" e selecione a pasta do projeto "api-deliverymuch" e clique em "OK";
 5. Clique em "Finish" e espere o projeto carregar;
 6. Após, clique em "src/test/java";
 7. Clique no pacote "api.testSuite" e com o botão direito sobre o "apiSuiteTest.java" e selecione "Run As" e após "JUnit Test";
 8. Espere o caso de teste ser executado;
 9. Ao terminar acesse a pasta do projeto "api-deliverymuch" e clique para abrir os relatórios: "ResultadoIngles.html" e "ResultadoPortugues.html" no navegador web onde você poderá verificar o resultado gerado.

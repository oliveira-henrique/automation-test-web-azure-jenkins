# language: pt
# charset: UTF-8

@Plan_Id=69226
@Des_Suite_Id=69235
@Qa_Suite_Id=69233
@Hom_Suite_Id=69234
Funcionalidade: Login
   Eu como cliente gostaria de acessar o sistema via login somente com credenciais validas

  @Test_Id=69230
   Cenario: Executar login com credenciais validas
    Dado eu estou na pagina de login
    Quando eu efetuar o login com credencias validas
    Entao sera apresentado a tela do menu principal

  @Test_Id=69231
  @funcional
  @aceitacao
  Cenario:  Executar login com credenciais invalido
    Dado eu estou na pagina de login
    Quando eu efetuar o login com credencias invalidas
    Entao sera apresentado uma mensagem de erro
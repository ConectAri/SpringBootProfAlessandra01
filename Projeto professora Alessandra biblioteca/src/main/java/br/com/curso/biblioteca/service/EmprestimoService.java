package io.github.jiangdequan;


/* A anotação @Service é uma anotação do Spring Framework que serve para marcar uma
 classe como um componente de serviço. Ao marcar uma classe com essa anotação,
 o Spring irá gerenciar o ciclo de vida desse componente e permitir que ele seja 
 injetado em outras classes que dependem dele.
.....*/

@Service
public class EmprestimoService {

    // método que realiza a operação de empréstimo de uma obra para um usuário
    //deixei public para indicar que o método pode ser acessado por qualquer outra classe dentro do mesmo pacote
    //ou em outros que importem o pacote de referência
    //O primeiro parâmetro é do tipo "Usuario", que representa o usuário que está solicitando o empréstimo,
    // e o segundo parâmetro é do tipo "Obra", que representa a obra que está sendo emprestada.
    // o método pode lançar uma exceção do tipo "Exception" em caso de algum problema durante a execução.
    public void emprestaObra(Usuario usuario, Obra obra) throws exception{

     // Verificando se o usuário é um estudando ou professor:
    
     // Ao inicializar a variável com o valor zero, o código garante que a variável não terá um valor
     // não-inicializado, que poderia gerar erros ou comportamentos inesperados durante a execução.
     // Além disso, se houver alguma falha durante a definição do valor de "limiteObrasEmprestadas",
     // o valor padrão será zero, o que pode ser útil para identificar que houve algum problema com a lógica do código.
     
     int limiteObrasEmprestadas = 0;

     if(usuario instanceof Estudante){
        limiteObrasEmprestadas = 5; //regra que a professora determinou para estudante
     } else if (usuario instanceof Professor){
        limiteObrasEmprestadas = 10; //regra que a professora determinou para estudante
     }else{
        throw new Exception("Tipo de usuário inválido.");
     }
     
     //Verificando se o número máximo de obras permitido já foi alcançado, 
          
     if (usuário.getNumObrasEmprestadas() >= limiteObrasEmprestadas){
         throw new Exception("Limite máximo de obras emprestadas alcançado");
        }
        
        //Aqui ocorre uma atualização do número de obras emprestadas incrementando
        // em uma unidade após cada operação de empréstimo
        usuario.setNumObrasEmprestadas(usuario.getNumObrasEmprestadas() + 1);

        //Atualiza as informações da obra que está sendo emprestada, definindo seu status de disponibilidade
        // como "false" e atribuindo o usuário que solicitou o empréstimo à obra em questão.
        obra.setDisponível(false);
        obra.setUsuario(usuario);

        //Gravando a transação no banco de dados
        //

        EntityManager em = getEntityManager(); // cria uma instância do EntityManager que será usada para
        // gerenciar as entidades que serão persistidas no banco de dados.

        try{ //bloco try-catch-finally é usado para gerenciar as transações de forma segura
            em.getTransaction().begin();//inicia uma nova transação no banco de dados
            em.merge(usuario);//A operação "merge" é usada para atualizar a entidade no banco
            em.merge(obra);// de dados ou inseri-la caso ainda não exista.
            em.getTransaction().commit();// finaliza a transação, confirmando as alterações realizadas no banco de dados.
        }catch (Exception ex){
            em.getTransaction().rollback();
            throw ex;
        }finally{
            em.close();
         }
        }
    }

     /* 
     Explicanco o bloco try-catch-finally

     A linha "EntityManager em = getEntityManager();" cria uma instância do EntityManager que será usada para
     gerenciar as entidades que serão persistidas no banco de dados.

    O bloco try-catch-finally é usado para gerenciar as transações de forma segura, garantindo que elas sejam
    realizadas corretamente e que a conexão com o banco de dados seja liberada ao final do processo.

    A linha "em.getTransaction().begin();" inicia uma nova transação com o banco de dados.

    As linhas "em.merge(usuario);" e "em.merge(obra);" são usadas para persistir as entidades "usuario" e "obra"
    no banco de dados. A operação "merge" é usada para atualizar a entidade no banco de dados ou inseri-la caso ainda não exista.

    A linha "em.getTransaction().commit();" finaliza a transação, confirmando as alterações realizadas no banco
     de dados.

    O bloco catch é responsável por capturar e tratar exceções que possam ocorrer durante o processo de persistência das entidades. Caso alguma exceção seja lançada, a linha "em.getTransaction().rollback();" é usada para desfazer as alterações realizadas durante a transação. Em seguida, a exceção é relançada para que possa ser tratada em outro ponto do código.

    O bloco finally é usado para garantir que a conexão com o banco de dados seja liberada ao final do processo. A linha "em.close();" é usada para fechar a conexão com o banco de dados.

    Resumindo, o código que você postou é responsável por criar uma nova transação com o banco de dados, persistir as entidades "usuario" e "obra" e confirmar as alterações realizadas no banco de dados. Caso ocorra alguma exceção durante o processo, as alterações são desfeitas e a conexão com o banco de dados é liberada. Ao final do processo, a conexão com o banco de dados é sempre liberada para evitar possíveis vazamentos de memória.
     
     
     .....*/   










# Projeto demonstrativo usando JDBC e DAO(Data Access Object)

## Sobre o Projeto
Tendo a base de estudo sobre a API JDBC, foi criado implementações para consultas(findById, findAll, findByDepartment), deleção(deleteById), renomear itens de uma coluna (update), deletar(deleteById) e inserir(insert). Todas as implementações serão para modificar as tabelas seller(vendedor) e department(departamento).
Foi utilizado banco de dados MySQL e seu driver para realizar o teste e conexão. Na construção do projeto foi usado o padrão de projetos DAO.

### Diagrama de classes sobre a construção das entidades Department e Seller
![alt text](/assets/Entidades.png?raw=true "Entidades")

### Driagrama de classes usando o padrão de projeto DAO
![alt text](/assets/diagrama.png?raw=true "Diagrama")

### Descrição
* As interfaces **SellerDao** e **DepartmentDao** com as assinaturas dos metodos, representam as implementações padrão que devem ser realizadas pelas classes filhas, ou seja, irão conter toda a lógica com o banco de dados.
* As classes **SellerDaoJDBC** **DepartmentDaoJDBC** implementam **SellerDao** e **DepartmentDao** respectivamente, onde é feito toda a lógica responsavel pela comunicação e operação desejada com o banco de dados com **JDBC**.
* Já a interface **DaoFactory** é responsavel pela **injeção de dependencia**, onde os metodos são responsaveis pela criação das instancias das classes responsaveis pelo código com o banco de dados, ou seja, retorna o tipo da interface correspondente mas instancia uma *implementação não explicita*.
* É possivel perceber a facil manutenção, já que SellerDaoJDBC é um modo de acesso, porém poderia ser feito de outra maneira, surgindo uma nova classe que implementa SellerDao e realiza o código responsavel, a importancia do DaoFactory se encontra nessa parte, onde se haver a necessidade de outro acesso, deverá ter a classe responsavel pelo acesso e a mudança apénas em DaoFactory, pois retorna o tipo correspondente e a implementação não explicita. Tornando mais flexivel a manutenção.
* Obs: Para acessar o banco de dados(MySQL) foram guardados o usuario, senha, url e opção de useSSL(booleano) no arquivo *db.properties* que é carregado pelo método *loadProperties()* em *DB.java*

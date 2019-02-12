## **iFace**
**Aluno:** André Luiz de Oliveira Cezário

### **Funcionalidades**

**1 - Criação de Conta (Implementada)**

Para criação de conta, foi adicionado um método criarConta(Usuario u) na classe *BD*, que recebe como parâmetro um objeto do tipo Usuario, previamente criado
a partir de informações inseridas pelo usuário na Main. Este objeto é adicionado em um ArrayList do tipo Usuario. 

**2 - Criação/Edição de Perfil (Implementada)**

Para edição do perfil não foi criado um método a parte, apenas solicitado na própria *Main* o atributo que queria ser editado e atualizado através do seu setter.

**3 - Adição de Amigos (Implementada)**

Para adição de amigos, também não foi criado um método a parte, foi solicitado na *Main* o nome do amigo para adicionar e feita uma busca na base de dados,
através do método buscarUsuarioNome(String nome) na classe *BD*, adicionando nas solicitações do usuário solicitado como amigo.

**4 - Envio de Mensagens (Implementada)**

Para envio de mensagens, como nas anteriores não foi criado um método a parte, na *Main* foi solicitado se o envio seria para um usuário ou comunidade, e dependendo,
solicitado o nome do usuário ou nome da comunidade para busca, através dos métodos buscarUsuarioNome(String nome) e buscarComunidade(String nome), respectivamente. Posteriormente, solicitado
o conteúdo da mensagem, de modo que se fosse para um usuário era atualizado a lista de mensagens enviadas no remetente e recebidas no destinatário, e se fosse para uma comunidade o remetente atualizava sua lista
de mensagens enviadas com todos os membros daquela comunidade e cada membro da comunidade recebia uma mensagem do remetente.

**5 - Criação de Comunidades (Implementada)**

Para criação de conta, foi adicionado um método criarComunidade(Comunidade com) na classe *BD*, que recebe como parâmetro um objeto do tipo Comunidade, previamente criado
a partir de informações inseridas pelo usuário na Main. Este objeto é adicionado em um ArrayList do tipo Comunidade. 

**6 - Adição de membros (Implementada)**

Para adição de membros em uma comunidade, não foi adicionado nenhum método específico, o mesmo foi implementado na Main.

**7 - Recuperar Informações sobre um determinado Usuário (Implementada)**

Para essa funcionalidade, foi criado um método recuperarInfo(String nomeUsuario) na classe *BD* que recebe uma string nome e faz uma busca do mesmo na lista de usuários cadastrados.

**8 - Remoção de Conta (Implementada)**

Para remoção de conta, foi adicionado um método removerConta(String login) na classe *BD*. Removendo o objeto usuário da base de dados e por conseguinte suas informações, relacionamentos e mensagens enviadas.

### **Classes**

**Usuario**
- Motivação

A classe Usuario foi criada para armazenar informações referentes a conta de cada usuário do sistema, 
de acordo com o domínio do problema.

- Solução

Com esta classe foi possível modularizar melhor o problema, concentrando as informações e dados pertinentes ao usuário em uma
única classe. A mesma possui um construtor que recebe o login, nome e senha do usuário que são as informações obrigatórias para 
criação do perfil. Os outros atributos dizem respeito a arrays (Collections) que armazenam solicitações, comunidades, mensagens enviadas e recebidas 
e novos atributos, estas informações são preenchidas de acordo com a utilização de outras classes do sistema, como Main e BD.

- Vantagens

Reunir todas as informações do usuário em uma única classe, de modo que seja possível obter todos os dados de um determinado objeto usuário, manipulando
a classe *Usuario*.


**Mensagem**
- Motivação

Assim como, a classe Usuario, a classe Mensagem diz respeito ao domínio do problema, sua motivação também foi concentrar as informações
pertinentes a entidade mensagem em uma única classe.

- Solução

Neste caso, como toda mensagem possui um remetente, destinatário e conteúdo, estes foram os atributos da classe *Mensagem*, todos obrigatórios.
Para isso foi criado um construtor que recebe os três atributos como parâmetro.

- Vantagens

Reunir todas as informações da mensagem em uma única classe, de modo que é possível obter todos os dados de um determinado objeto mensagem, manipulando
a classe *Mensagem*.

**Comunidade**
- Motivação

Como no sistema temos uma entidade comunidade, na qual a administração (propriedade) é atribuída a um usuário e a mesma pode ter associação de membros,
foi criada a classe *Comunidade* para isso.

- Solução

Nesta classe, temos como atributo um nome que serve como identificador da classe no sistema, assim como uma descrição e o proprietário que é um tipo Usuario e membros que são uma ArrayList de objetos
do tipo Usuario. Para criação de uma comunidade é obrigatório que sejam informados o nome, descrição e proprietário, que são os parâmetros do construtor.

- Vantagens

A vantagem, assim como nas anteriores está na modularização do problema mais geral em entidades relacionadas ao domínio ou negócio 
do sistema. De modo que, facilita a busca e utilização de informações importantes para o funcionamento das funcionalidades do sistema.

**BD**
- Motivação
Armazenamento de usuários e comunidades criados, bem como para criação de métodos que implementam funcionalidades do sistema e operações de 
CRUD. Sendo está classe requisitada pela Main sempre que necessário.

- Solução
Para armazenamento de todos os usuários e comunidades do sistema, foram criados dois ArrayList do tipo Usuario e Comunidade, respectivamente. Vale ressaltar que armazenar mensagens não foi necessário, pois estas
estão associadas aos usuários, logo não foi preciso duplicar isto no banco. Na implementação das funcionalidades, foram implementados métodos
para criação de conta, busca de usuário por login e nome, remoção de conta, criação e busca de comunidades, bem como busca de mensagens de um usuário.

- Vantagens
Armazenamento de todas as contas e comunidades criadas em um única classe, bem como para operações de CRUD e de funcionalidades. Facilitando o reuso em outras classes, como na Main.

**Main**
- Motivação
A classe main foi criada para implementar a GUI na qual são recebidas as entradas e exibidos os resultados para o usuário no console.

- Solução
Neste caso foi utilizado o Scanner como canal de entrada e no console foram exibidas de forma concisa e simples os passos que o usuário poderia seguir para acessar as funcionalidades do sistema. De acordo com a operação eram realizadas chamadas de métodos ou acesso a atributos da classe *BD*, onde essa era um atributo 
(objeto) da classe *Main*.

- Vantagens
Implementação da GUI.

### **Distribuição dos Métodos**

Os métodos mais gerais como Getters, setters e toString foram adicionadas nas classes da camada lógica do problema, em *Usuario*, *Mensagem*, *Comunidade*

Já os métodos mais específicos que dizem respeito a implementação de funcionalidade propriamente ditas do sistema, foram todos adicionados na classe de banco de dados
*BD*, especificamente:

- criarConta(Usuario u)
- buscarUsuario(String login)
- buscarUsuarioNome(String nome)
- removerConta(String login)
- recuperarInfo(String nome)
- recuperarInfoLogin(String login)
- criarComunidade(Comununidade com)
- buscarComunidade(String nome)
- buscarMensagens(String nome, String usuarioLogado)

A motivação para isso foi o reuso de métodos que são invocados mais de uma vez na *Main*, como os métodos de busca, além da implementação de outros métodos
que atendem funcionalidades específicas. Está solução permite que esses métodos sejam reaproveitados em outra classe, onde poderão ser invocados a qualquer
momento, a escolha da classe *BD* para estes métodos, é justamente por a mesma obter todos os dados armazenados e as operações do sistema necessitarem dessas
informações para serem implementadas, além de proporcionar o reuso, como já citado.

### **Reuso**

Foi utilizado reuso criando métodos para comportamentos que eram necessários em mais de uma operação do sistema, principalmente os métodos
de busca (buscarUsuario(String login) e buscarComunidade(String nome))e recuperação de informações. Neste caso, todos foram agrupados na classe *BD* e sempre que requisitados na *Main* para efetuar alguma
funcionalidade, eram invocados a partir de um objeto do tipo BD. 

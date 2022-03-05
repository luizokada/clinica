# clinica

1. Criar uma tela com 4 botões


2. No primeiro botão, deve ser utilizado para cadastrar um paciente com
os seguintes dados:

a. Código (gerado automaticamente)

b. Nome do paciente

c. Data de nascimento

d. Endereço

e. Observações.


3. No segundo botão, deve ser utilizado para editar um paciente:

a. Ao clicar nele, deve dar a opção de pesquisar um paciente cadastrado
e alterar os dados cadastrados dele.


4. No terceiro botão, deve ser utilizado para listar todos os pacientes
cadastrados.


5. No quarto botão, deve permitir excluir um paciente cadastrado.

Como usar:

Esse projeto foi desenvolvido na IDE Eclipse para rodar o código primeiro é necessário que você tenha criado um database local.
No arquivo localizado em base/bancoDeDados na linha 9:
return  DriverManager.getConnection("jdbc:mysql://localhost:3306/teste?useTimezone=true&serverTimezone=UTC", "root", "Omegacode@01");

troque teste pelo nome do database que foi criado localmente e onde esta "root" troque para o usuário local e onde está senha troque para a senha 
de acesso desse usuário

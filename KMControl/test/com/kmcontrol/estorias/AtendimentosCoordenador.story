Story: Listar Chamados
como coordenador
eu gostaria de listar os chamados do tecnico por data
para que que consiga fazer o pagamento semanalmente

Scenario: Listagem de chamados por data
@given apos tecnico ter cadastrado os chamados
@when selecionar o tecnico <tecnico>
@when selecionar a data inicial <datainicial>
@then retorna a lista <listachamados>


Examples:
|tecnico|datainicial|listachamados|
|||
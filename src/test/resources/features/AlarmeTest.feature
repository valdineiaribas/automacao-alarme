#language: pt

Funcionalidade: Alarme

Como usuário do sistema de relógio
Usuário deseja gerenciar os alarmes
Para que seja alertado nos horários escolhidos

Cenário: Adicionar novo alarme 
	Dado que usuário esteja na aba de alarme
	Quando usuário clicar no botão +
	E selecionar o horário do alarme como 1 hora e 20 minutos 
	E selecionar PM
	E clicar em ok
	Então um novo alarme deve ser criado
-- Insere clientes iniciais para o sistema ja abrir com dados.
insert into clientes (nome, telefone, email, profissional) values
('Ana Souza', '11999998888', 'ana@cliente.com', false),
('Bruno Colorista', '11988887777', 'bruno@pro.com', true),
('Camila Lopes', '21977776666', 'camila@cliente.com', false);

-- Insere servicos iniciais do salao.
insert into servicos (nome, preco_base, categoria) values
('Corte Feminino', 80.00, 'CORTE'),
('Hidratacao Profunda', 120.00, 'TRATAMENTO'),
('Tintura Completa', 180.00, 'COLORACAO');

-- Insere produtos iniciais.
insert into produtos (nome, preco, estoque, categoria) values
('Shampoo Nutritivo', 45.00, 20, 'SHAMPOO'),
('Condicionador Repair', 49.90, 15, 'CONDICIONADOR'),
('Mascara Reconstrutora', 69.90, 10, 'MASCARA');

-- Insere cursos iniciais para teste.
insert into cursos (titulo, preco, vagas, nivel) values
('Curso de Corte de Cabelo', 450.00, 8, 'INICIANTE'),
('Curso de Tintura Profissional', 650.00, 5, 'AVANCADO');

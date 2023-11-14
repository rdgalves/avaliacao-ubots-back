-- Criação da tabela Atendentes
CREATE TABLE atendentes (
    atendente_id SERIAL PRIMARY KEY,
    nome VARCHAR(100),
    equipe VARCHAR(50) CHECK (equipe IN ('CARTOES', 'EMPRESTIMOS', 'OUTROS_ASSUNTOS')),
    atendimentos_simultaneos INTEGER DEFAULT 0
);

-- Criação da tabela Solicitações
CREATE TABLE solicitacoes (
    solicitacao_id SERIAL PRIMARY KEY,
    tipo VARCHAR(50) CHECK (tipo IN ('PROBLEMAS_COM_CARTAO', 'CONTRATACAO_EMPRESTIMO', 'OUTROS')),
    status VARCHAR(50) CHECK (status IN ('PENDENTE', 'EM_ATENDIMENTO', 'CONCLUIDA')),
    cliente_id INTEGER, -- Caso precise existir vinculo com cliente em algum momento
    atendente_id INTEGER,
    FOREIGN KEY (atendente_id) REFERENCES atendentes(atendente_id)
);

CREATE TABLE fila_solicitacoes (
    fila_id SERIAL PRIMARY KEY,
    solicitacao_id INT NOT NULL,
    equipe VARCHAR(50) CHECK (equipe IN ('CARTOES', 'EMPRESTIMOS', 'OUTROS_ASSUNTOS')),
    data_hora_enfileiramento TIMESTAMP,
    FOREIGN KEY (solicitacao_id) REFERENCES solicitacoes(solicitacao_id)
);


INSERT INTO atendentes (nome, equipe, atendimentos_simultaneos) VALUES ('João Silva', 'CARTOES', 0);
INSERT INTO atendentes (nome, equipe, atendimentos_simultaneos) VALUES ('Maria Oliveira', 'EMPRESTIMOS', 0);
INSERT INTO atendentes (nome, equipe, atendimentos_simultaneos) VALUES ('Carlos Pereira', 'OUTROS_ASSUNTOS', 0);
--INSERT INTO atendentes (nome, equipe, atendimentos_simultaneos) VALUES ('Ana Santos', 'CARTOES', 0);
--INSERT INTO atendentes (nome, equipe, atendimentos_simultaneos) VALUES ('Luiz Costa', 'EMPRESTIMOS', 0);

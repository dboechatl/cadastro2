-- Criação do banco de dados
CREATE DATABASE IF NOT EXISTS bdgaleria;

-- Uso do banco de dados
USE bdgaleria;

-- Criação da tabela 'obradearte'
CREATE TABLE IF NOT EXISTS obradearte (
    obra_id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(150) NOT NULL,
    artista VARCHAR(100) NOT NULL,
    ano_criacao YEAR NOT NULL,
    descricao TEXT NOT NULL,
    valor_estimado DECIMAL(15, 2) NOT NULL,
    status_disponibilidade INT NOT NULL,
    categoria VARCHAR(50) NOT NULL
);

-- Inserção dos dados na tabela 'obradearte'
INSERT IGNORE INTO obradearte (titulo, artista, ano_criacao, descricao, valor_estimado, status_disponibilidade, categoria)
VALUES
('Mona Lisa', 'Leonardo da Vinci', 1503, 'Retrato de uma mulher com um sorriso enigmático.', 870000000.00, 1, 'Retrato'),
('O Grito', 'Edvard Munch', 1893, 'Representação expressionista do desespero humano.', 120000000.00, 1, 'Expressionismo'),
('A Noite Estrelada', 'Vincent van Gogh', 1889, 'Céu noturno turbulento sobre uma vila.', 100000000.00, 1, 'Paisagem'),
('Guernica', 'Pablo Picasso', 1937, 'Obra icônica contra a guerra e violência.', 200000000.00, 0, 'Modernismo'),
('O Beijo', 'Gustav Klimt', 1907, 'Representação simbólica de amor e erotismo.', 150000000.00, 1, 'Simbolismo'),
('David', 'Michelangelo', 1504, 'Escultura renascentista de um jovem herói bíblico.', 500000000.00, 0, 'Escultura'),
('A Persistência da Memória', 'Salvador Dalí', 1931, 'Relógios derretendo em um cenário onírico.', 80000000.00, 1, 'Surrealismo'),
('As Meninas', 'Diego Velázquez', 1656, 'Cena de um grupo de figuras em um palácio.', 150000000.00, 0, 'Barroco'),
('O Jardim das Delícias Terrenas', 'Hieronymus Bosch', 1505, 'Tríptico explorando temas de pecado e salvação.', 200000000.00, 0, 'Renascimento'),
('A Criação de Adão', 'Michelangelo', 1512, 'Detalhe do teto da Capela Sistina.', 450000000.00, 0, 'Renascimento'),
('Campbell\'s Soup Cans', 'Andy Warhol', 1962, 'Série que representa latas de sopa Campbell.', 15000000.00, 1, 'Pop Art'),
('O Nascimento de Vênus', 'Sandro Botticelli', 1486, 'Representação renascentista do mito de Vênus.', 300000000.00, 1, 'Renascimento'),
('A Última Ceia', 'Leonardo da Vinci', 1498, 'Cena bíblica do momento em que Jesus anuncia a traição.', 400000000.00, 0, 'Renascimento'),
('A Liberdade Guiando o Povo', 'Eugène Delacroix', 1830, 'Símbolo do romantismo e da revolução francesa.', 120000000.00, 1, 'Romantismo'),
('Noite de Verão', 'Edvard Munch', 1890, 'Paisagem expressionista com reflexos na água.', 50000000.00, 1, 'Expressionismo');

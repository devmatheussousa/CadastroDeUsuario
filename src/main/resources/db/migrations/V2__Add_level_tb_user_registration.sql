-- V2: Migrations para adicionar a coluna de level na tabela User Registration

ALTER TABLE tb_user_registration
ADD COLUMN level VARCHAR(255);

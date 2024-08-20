Realizar o clone do repositorio

Criar a imagem a partir do dockerfile que possui na estrutura do projeto

comando : docker build -f dockerfile -t atividade .

rodar o container na porta desejada
docker run -p 8080:8080 atividade

Abrir a web digitar localhost:porta/GET

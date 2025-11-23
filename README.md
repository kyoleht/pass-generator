# 📘 **Password Generator – Java + JavaFX**

Um gerador de senhas simples, bonito e totalmente funcional feito em **Java** utilizando **JavaFX**.
Este projeto permite que o usuário escolha o tamanho da senha, valide a entrada e gere uma senha segura composta por letras maiúsculas, minúsculas, números e símbolos especiais.

Ideal para estudos, prática de lógica de programação, JavaFX, interface gráfica e boas práticas de desenvolvimento.

---

## 🚀 **Funcionalidades**

* ✔ Geração de senhas fortes e aleatórias
* ✔ Interface gráfica estilizada com JavaFX
* ✔ Campo para inserir o tamanho da senha
* ✔ Validações inteligentes:

  * impede texto vazio
  * impede números inválidos
  * impede valores muito pequenos
  * impede valores exageradamente grandes
  * impede caracteres não-numéricos
* ✔ Exibição clara da senha gerada
* ✔ Mensagens de erro amigáveis

---

## 🖼 **Demonstração da Interface**

A interface foi construída com foco em simplicidade e organização.

* Título centralizado
* Caixa para digitar o tamanho da senha
* Botão estilizado
* Campo com a senha gerada em destaque
* Fundo levemente colorido

---

## 📁 **Estrutura do Projeto**

```
PasswordGenerator/
│
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── example/
│                   └── PassGenerator.java
│
├── README.md
└── pom.xml  (caso use Maven)
```

---

## ⚙ **Tecnologias Utilizadas**

* **Java 17+**
* **JavaFX 17+**
* **SecureRandom** para geração de dados realmente aleatórios
* **Scene, Label, Button, TextField, VBox** para construção da interface

---

## 🔐 **Como funciona a geração de senha**

A senha é montada com base nesta lista de caracteres:

```
ABCDEFGHIJKLMNOPQRSTUVWXYZ
abcdefghijklmnopqrstuvwxyz
0123456789
!@#$%^&*()-_=+[]{}|;:,.<>?/
```

Cada caractere é escolhido aleatoriamente usando:

```java
SecureRandom random = new SecureRandom();
```

Esse tipo de random é mais seguro que o `Random` normal, já que foi criado justamente para operações que exigem aleatoriedade forte.

---

## 🧠 **Lógica do Programa**

1. O usuário digita o tamanho desejado da senha
2. O botão “Generate Password” é clicado
3. O sistema valida se o tamanho é:

   * um número
   * maior ou igual a 4
   * menor que 100
4. Se tudo estiver certo, chama `generatePass(length)`
5. A senha gerada aparece na tela

---

## 🚨 **Validações Implementadas**

Quando o input for inválido, o app mostra um alerta explicando o erro:

* ❌ Campo vazio
* ❌ Número muito pequeno
* ❌ Número muito grande
* ❌ Letras ou símbolos no campo
* ❌ Qualquer coisa que impeça a conversão para inteiro

Exemplo de validação:

```java
if (length < 4) {
    showError("Password must be at least 4 characters long.");
}
```

---

## 📦 **Como executar o projeto**

### 🔹 **1. Certifique-se de ter o Java instalado**

Recomendado: **Java 17 ou superior**

Para verificar:

```
java -version
```

---

### 🔹 **2. Certifique-se de ter JavaFX instalado**

Se estiver usando Maven, adicione as dependências:

```xml
<dependency>
    <groupId>org.openjfx</groupId>
    <artifactId>javafx-controls</artifactId>
    <version>17</version>
</dependency>
```

---

### 🔹 **3. Compile o programa**

No terminal:

```
javac PassGenerator.java
```

---

### 🔹 **4. Execute o programa**

```
java PassGenerator
```

Ou pelo Maven:

```
mvn javafx:run
```

---

## 🎨 **Possíveis Melhorias Futuras**

### 🔧 Funcionalidades:

* Copiar senha com um botão “Copy to Clipboard”
* Gerar senhas com regras opcionais:

  * apenas números
  * incluir símbolos
  * incluir maiúsculas
  * incluir minúsculas
* Mostrar força da senha (fraca / média / forte)

### 🎨 Visual:

* Modo escuro
* CSS externo para estilos avançados
* Ícones e temas personalizados

### 🌐 Publicação:

* Empacotar com Maven
* Criar versão `.exe` usando jpackage
* Colocar o projeto no GitHub com prints e GIF
* Criar um mini-site falando sobre ele

---

## 📜 **Licença**

Este projeto é totalmente livre para uso pessoal, estudo e modificação.
Sinta-se à vontade para melhorar, estudar ou incluir em seu portfólio.

---

## ✨ **Autor**

Projeto desenvolvido por **Rafa** 💛
Com foco em aprendizado, lógica de programação e desenvolvimento Java.

Bash
mvn archetype:generate -DgroupId=com.example -DartifactId=meuprojeto -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
Java
package com.example;

public class Pessoa {
    public String dizerOla() {
        return "Olá, Mundo!";
    }
}
package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PessoaTest {
    @Test
    public void testDizerOla() {
        Pessoa pessoa = new Pessoa();
        String resultado = pessoa.dizerOla();
        assertEquals("Olá, Mundo!", resultado);
    }
}
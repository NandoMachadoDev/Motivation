package com.nubank.esboco.data

import com.nubank.esboco.infra.MotivationConstants
import kotlin.random.Random

data class Frases(val description: String, val categoryId: Int)

class Mock {

    private val infinito = MotivationConstants.FILTER.INFINITO
    private val rosto = MotivationConstants.FILTER.ROSTO
    private val noite = MotivationConstants.FILTER.NOITE

    private val mListFrases = listOf<Frases>(
        Frases("Não sabendo que era impossível, foi lá e fez.", rosto),
        Frases("Você não é derrotado quando perde, você é derrotado quando desiste!", rosto),
        Frases("Quando está mais escuro, vemos mais estrelas!", rosto),
        Frases("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", rosto),
        Frases("Não pare quando estiver cansado, pare quando tiver terminado.", rosto),
        Frases("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", rosto),
        Frases("A melhor maneira de prever o futuro é inventá-lo.", noite),
        Frases("Você perde todas as chances que você não aproveita.", noite),
        Frases("Fracasso é o condimento que dá sabor ao sucesso.", noite),
        Frases(" Enquanto não estivermos comprometidos, haverá hesitação!", noite),
        Frases("Se você não sabe onde quer ir, qualquer caminho serve.", noite),
        Frases("Se você acredita, faz toda a diferença.", noite),
        Frases("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", noite)
    )

    fun getFrases(fra: Int): String {
        val filtered = mListFrases.filter { (it.categoryId == fra || fra == infinito) }
        val rand = Random.nextInt(filtered.size)
        return filtered[rand].description
    }

}
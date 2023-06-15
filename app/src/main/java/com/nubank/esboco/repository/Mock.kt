package com.nubank.esboco.repository

import com.nubank.esboco.infra.MotivationConstants
import kotlin.random.Random

data class Frases(val description: String, val categoryId: Int, val lang: String)

class Mock {

    private val infinito = MotivationConstants.FILTER.INFINITO
    private val rosto = MotivationConstants.FILTER.ROSTO
    private val noite = MotivationConstants.FILTER.NOITE

    private val langPt = MotivationConstants.LANGUAGE.PORTUGUESE
    private val langEn = MotivationConstants.LANGUAGE.ENGLISH
    private val langFr = MotivationConstants.LANGUAGE.FRENCH

    private val mListFrases = listOf<Frases>(
        Frases("Não sabendo que era impossível, foi lá e fez.", rosto, langPt),
        Frases(
            "Você não é derrotado quando perde, você é derrotado quando desiste!",
            rosto,
            langPt
        ),
        Frases("Quando está mais escuro, vemos mais estrelas!", rosto, langPt),
        Frases(
            "Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.",
            rosto,
            langPt
        ),
        Frases("Não pare quando estiver cansado, pare quando tiver terminado.", rosto, langPt),
        Frases(
            "O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?",
            rosto,
            langPt
        ),
        Frases("A melhor maneira de prever o futuro é inventá-lo.", noite, langPt),
        Frases("Você perde todas as chances que você não aproveita.", noite, langPt),
        Frases("Fracasso é o condimento que dá sabor ao sucesso.", noite, langPt),
        Frases(" Enquanto não estivermos comprometidos, haverá hesitação!", noite, langPt),
        Frases("Se você não sabe onde quer ir, qualquer caminho serve.", noite, langPt),
        Frases("Se você acredita, faz toda a diferença.", noite, langPt),
        Frases(
            "Riscos devem ser corridos, porque o maior perigo é não arriscar nada!",
            noite,
            langPt
        ),
        Frases("Not knowing it was impossible, he went there and did it.", rosto, langEn),
        Frases(
            "You are not defeated when you lose, you are defeated when you give up!",
            rosto,
            langEn
        ),
        Frases("When it's darker, we see more stars!", rosto, langEn),
        Frases(
            "Insanity is always doing the same thing and expecting a different result.",
            rosto,
            langEn
        ),
        Frases("Don't stop when you're tired, stop when you're done.", rosto, langEn),
        Frases("What can you do now that has the biggest impact on your success?", rosto, langEn),
        Frases("The best way to predict the future is to invent it.", noite, langEn),
        Frases("You lose every chance you don't take.", noite, langEn),
        Frases("Failure is the spice that flavors success.", noite, langEn),
        Frases(" As long as we are not committed, there will be hesitation!", noite, langEn),
        Frases("If you don't know where you want to go, any way will do.", noite, langEn),
        Frases("If you believe, it makes all the difference.", noite, langEn),
        Frases(
            "Risks must be taken, because the greatest danger is not risking anything!",
            noite,
            langEn
        ),
        Frases("Ne sachant pas que c'était impossible, il y est allé et l'a fait.", rosto, langFr),
        Frases(
            "Tu n'es pas vaincu quand tu perds, tu es vaincu quand tu abandonnes!",
            rosto,
            langFr
        ),
        Frases("Quand il fait plus sombre, on voit plus d'étoiles!", rosto, langFr),
        Frases(
            "La folie, c'est toujours faire la même chose et s'attendre à un résultat différent.",
            rosto,
            langFr
        ),
        Frases("Ne t'arrête pas quand tu es fatigué, arrête quand tu as fini.", rosto, langFr),
        Frases(
            "Que pouvez-vous faire maintenant qui a le plus grand impact sur votre succès?",
            rosto,
            langFr
        ),
        Frases("La meilleure façon de prédire l'avenir est de l'inventer.", noite, langFr),
        Frases("Vous perdez toutes les chances que vous ne prenez pas.", noite, langFr),
        Frases("L'échec est l'épice qui parfume le succès.", noite, langFr),
        Frases("Tant qu'on n'est pas engagé, il y aura des hésitations!", noite, langFr),
        Frases(
            "Si vous ne savez pas où vous voulez aller, n'importe quoi fera l'affaire.",
            noite,
            langFr
        ),
        Frases("Si vous croyez, cela fait toute la différence.", noite, langFr),
        Frases(
            "Il faut prendre des risques, car le plus grand danger est de ne rien risquer!",
            noite,
            langFr
        )
    )

    fun getFrases(fra: Int, lang: String): String {
        val filtered = mListFrases.filter { (it.categoryId == fra || fra == infinito) && it.lang == lang }
        val rand = Random.nextInt(filtered.size)
        return filtered[rand].description
    }
}
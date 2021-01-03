package com.salva.juegosDeMesa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.salva.juegosDeMesa.model.Categorias
import com.salva.juegosDeMesa.model.DataHolder
import com.salva.juegosDeMesa.model.Editorial
import com.salva.juegosDeMesa.model.JuegosDeMesa
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_splash.*
import render.animations.*


class SplashActivity : AppCompatActivity() {
    val db = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Picasso.get().load(DataHolder.fondo).into(fondo)
        Picasso.get().load(DataHolder.icono).into(bgg)

        initData()
        startAnimation()
        Handler().postDelayed({
            logoEndAnimation()
            Handler().postDelayed({
                if( db.currentUser != null) {
                    startActivity(Intent(this, HomeActivity::class.java))

                }else{
                    startActivity(Intent(this, MainActivity::class.java))

                }
                finish()
            } ,700)
        } ,1000)

    }
    fun logoEndAnimation(){
        val render = Render(this)
        render.setAnimation(Fade().Out(bgg))
        render.setDuration(600)
        render.start()
    }
    fun startAnimation(){
        val render = Render(this)
        render.setAnimation(Attention().Tada(bgg))
        render.setDuration(900)
        render.start()
    }

    fun initData(){


        val devir =
            Editorial("Devir", "https://juegosdelamesaredonda.com/c/147-category_default/devir.jpg")
        val malditoGames = Editorial(
            "Maldito Games",
            "https://juegosdelamesaredonda.com/c/176-category_default/maldito-games.jpg"
        )
        val edge = Editorial("Edge", "https://juegosdemesayrol.com/wp-content/uploads/Cabecera-categoria-editorial-Edge-Entertainment.jpg")
        val ludonova = Editorial(
            " Ludonova",
            "https://i0.wp.com/www.elclubdante.es/wp-content/uploads/2018/10/logo_ludonova_FINAL.jpg"
        )
        val asmodee =
            Editorial("Asmodee", "https://maltedmeeple.com/wp-content/uploads/2017/01/Asmodee-Logo.png")
        val euroGame = Categorias(
            "eurogames",
            "Se conocen como juegos de estilo alemán, juegos de estilo europeo o eurojuegos, aquellos juegos de mesa temáticos desarrollados conforme a una filosofía que, a grandes rasgos, se caracteriza por los siguientes conceptos:\n" +
                    "\n" +
                    "Mayor incidencia en el sistema de juego que en su fidelidad al tema, que en ocasiones llega a funcionar como mera excusa para su creación.\n" +
                    "Fomento de la cooperación de todos los jugadores en el transcurso de la partida, sin que se produzca su eliminación temprana durante el juego o incluso implementando mecanismos para fomentar las posibilidades de recuperación de los más rezagados.\n" +
                    "Duración limitada, a lo sumo, a unas pocas horas.\n" +
                    "Escaso uso del lenguaje, a efectos de facilitar la internacionalización de los juegos; se minimiza el uso de texto escrito (excepto en las reglas), sustituyéndolo en lo posible por símbolos y dibujos, y no suelen requerir el uso de la palabra hablada.\n" +
                    "Y, en términos generales, su mayor sencillez respecto a juegos precedentes, derivados de la escuela anglosajona."
        )
        val dungeonCrawler = Categorias(
            "Dungeon crawler",
            "Un juego de mazmorras o juego de exploración de mazmorras (dungeon crawl en inglés: «avanzar lentamente por una mazmorra») es un tipo de aventura para juegos de tablero, de rol y videojuegos en la que los personajes jugadores exploran una gran mazmorra (u otra estructura laberíntica similar como un castillo o una cueva), luchando contra los dragones, orcos y cualquier otro monstruo que se encuentren en su camino y recolectando los tesoros que protegían. El término puede emplearse con un sentido peyorativo, ya que los juegos de mazmorras suelen carecer de argumento significativo y de consistencia lógica. Por ejemplo, el juego parodia Munchkin trata de \"la esencia de la experiencia en la mazmorra...\" matar monstruos, robar el tesoro, apuñalar a tu compañero. Lo anterior, sin embargo, los hace muy fáciles de dirigir para el director de juego y el estilo de juego hack and slash (literalmente, en inglés, «trinchar y acuchillar»), típico de este tipo de aventuras, es apreciado por muchos jugadores. Ayudas visuales como mapas, dioramas y miniaturas, son usadas a menudo para representar la situación de una mazmorra durante un juego de mazmorras"
        )
        val deckBuilder = Categorias(
            "Deck builder",
            "Un juego de construcción de mazos es un juego de naipes cuyo sistema de juego se centra en la creación de un conjunto de cartas óptimo para alcanzar las condiciones de victoria.\n" +
                    "\n" +
                    "Al igual que en los juegos de cartas coleccionables cada jugador construye su propio mazo, pero en este caso las cartas no se adquieren en sobres de contenido aleatorio, sino que el mazo se va construyendo en el transcurso de la partida con las cartas que el propio juego proporciona.\n" +
                    "\n" +
                    "Un caso típico es aquel en el que las cartas van proporcionando algún tipo de \"moneda de juego\" que permite al jugador adquirir nuevas cartas que añadir a su mazo."
        )
        val thematicGames = Categorias(
            "Juegos temáticos",
            "Se denomina juego temático a todo juego que tiene un tema o ambientación asociado. Esto es: a aquel cuyos elementos —fichas, dados, tablero, etc.— representan en alguna medida el comportamiento y características de seres u objetos reales , como eventos históricos o imaginarios, como películas, series o videojuegos.\n" +
                    "\n" +
                    "El término antónimo a «juego temático» sería «juego abstracto»."
        )
        val partyGames = Categorias(
            "Party Games",
            "Se denominan party games a aquellos juegos destinados a el entretenimiento de grandes grupos, incluyendo así un gran rango de jugadores. /n" +
                    "Se caracterizan principalmente por su sencillez en las reglas y su dinamismo siendo un claro ejemplo de ellos los juegos de trivial, mímica , o velocidad de racción"
        )
        val ameriTrash = Categorias(
            "ameritrash",
            "Se conocen como juegos de estilo americano aquellos juegos de mesa temáticos desarrollados conforme a una filosofía que, a grandes rasgos, se caracteriza por:\n" +
                    "\n" +
                    "La preeminencia del tema, al que se subordina la mecánica del juego.\n" +
                    "Animar el conflicto directo entre jugadores (lo que sucede incluso en algunos juegos semicooperativos como el Battlestar Galactica).\n" +
                    "Depender en un grado significativo del factor suerte.\n" +
                    "Gran despliegue de elementos (caja grande, multitud de figuras).\n" +
                    "Los juegos de estilo americano se diferencian también de los juegos de estilo alemán en que el estilo americano suele requerir tiempos de juego más largos. Además, su mecánica suele ser más compleja, para reflejar las características concretas de su tema, lo que puede llegar a incluir numerosas excepciones específicas para elementos individuales del juego"
        )
        val catan = JuegosDeMesa(
            "catan",
            "https://images-na.ssl-images-amazon.com/images/I/51iYSRyQF2L._AC_.jpg",
            "Catan es un juego de mesa para toda la familia que se ha convertido en un fenómeno mundial. Desde su aparición en Alemania ha vendido más que muchos de los juegos más tradicionales. Se trata de un juego que aúna la estrategia, la astucia y la capacidad para negociar y en el que los jugadores tratan de colonizar una isla, Catán, rica en recursos naturales. Construyendo pueblos, estableciendo rutas comerciales, etc… Catan ha vendido más de 2 millones de ejemplares en Europa y América. Por si esto no fuera bastante, ha sido galardonado en Alemania y Estados Unidos como Juego del Año. El juego básico de Catan, a la venta desde hace más de 10 años en España, ha marcado un hito en toda Europa en cuanto a juego de planificación, colaboración y, por supuesto, diversión. No hace falta comentar que es la única pieza indispensable de Catan en tu ludoteca. A partir del básico se abre todo el abanico de expansiones que la isla de Catán te ofrece.",
            devir,
            3,
            4,
            euroGame,
            75
        )
        val stoneAge = JuegosDeMesa(
            "Stone Age",
            "https://zavers.es/7550-large_default/juegos171.jpg",
            "Cada Era presenta unos retos específicos. La Edad de Piedra se caracterizó por el desarrollo de la agricultura, la manipulación de algunos recursos y la construcción de cabañas sencillas. Con la aparición del comercio, empieza también la expansión demográfica, los asentamientos y el desarrollo de las civilizaciones. Además, ciertas habilidades tradicionales, como la destreza en la caza, son muy apreciadas y demandadas, aunque solo sea para poder asegurar el crecimiento de la población. El objetivo de los jugadores será conseguir afrontar y superar estos desafíos. Habrá varias formas de lograrlo, así que cada uno puede intentar hacerlo a su modo. Elige un camino y podrás saber, al final de la partida, si has hecho la mejor elección.",
            devir,
            2,
            4,
            euroGame,
            90
        )
        val terraforming = JuegosDeMesa(
            "Terraforming mars",
            "https://dragonesylosetas.com/wp-content/uploads/2019/07/terraforminsmarsdesp-300x300.jpg",
            "En Terraforming Mars, los jugadores desarrollan el rol de una corporación con un perfil determinado y trabajan juntos en el proceso de terraformación, pero compiten por obtener los puntos de victoria que otorgan no solo tus contribuciones a Marte, sino también las mejoras de la infraestructura humana a través del sistema solar. Al comienzo de cada ronda (llamadas “generaciones”), adquirirán cartas de proyecto únicas (de un mazo con más de 200), mediante las cuales podrán hacer acciones muy variadas: desde introducir nuevas especies de vida vegetal o animal, hasta lanzar asteroides a la superficie marciana, construir ciudades o minar las lunas de Júpiter para extraer valiosos recursos (acero, titanio, energía…). Los Proyectos Estándar también permiten a los jugadores terraformar Marte independientemente de los proyectos que se adquieran.",
            malditoGames,
            1,
            5,
            euroGame,
            120
        )
        val arcadia = JuegosDeMesa(
            "Arcadia Quest" ,
            "https://ksr-ugc.imgix.net/assets/011/654/850/dc72e74864abd004ca6857a63a70a899_original.jpg?ixlib=rb-2.1.0&crop=faces&w=1552&h=873&fit=crop&v=1463686321&auto=format&frame=1&q=92&s=95718e6b3d7e802815cbfad5614fcb90",
            "En Arcadia Quest, los jugadores crean sus Gremios con 3 de los 12 Héroes disponibles, cada uno de ellos con sus propias capacidades únicas. A medida que avanzan en una campaña llena de ramificaciones y liberan los barrios de Arcadia de los monstruos que los ocupan, los Héroes obtienen nuevas armas, capacidades y objetos mágicos. Los jugadores combinan el botín obtenido con las capacidades innatas de sus Héroes para hacer de su Gremio el más poderoso de Arcadia" ,
            edge,
            2,
            4,
            dungeonCrawler,
            60

        )
        val orquesta = JuegosDeMesa(
            "Orquesta negra : Hitler debe morir",
            "https://tse2.mm.bing.net/th?id=OIP.nmDJ2GXGPa8MjRlLvczekgAAAA&pid=Api&P=0&w=172&h=169",
            "Orquesta Negra es un juego puramente cooperativo en el que cada jugador encarnará a uno de los conspiradores de ese grupo y entre todos intentarán acabar con la vida de Hitler para evitar el colapso de Alemania y salvar el mayor número de vidas posibles, pero la tarea no será fácil pues el tiempo apremia y la Gestapo estrecha su cerco sobre los conspiradores.",
            ludonova,
            1,
            6,
            thematicGames,
            90
        )

        val timesUp = JuegosDeMesa(
            "Time's up",
            "https://jcsatanas.fr/wp-content/uploads/2015/03/Times-up-version-bleue-et-jaune.jpg",
            "Time’s Up! es un party game por equipos donde trataréis de dar pistas a vuestro compañero o compañeros de equipo para adivinar un personaje histórico o de ficción. Antes de que el juego comience, se reparten las cartas entre los jugadores que tendrán que hacer una selección. Todas las cartas se barajan juntas formando un mazo para ambos equipos.",
            asmodee ,
            4,
            12,
            partyGames ,
            40
        )
        addCategorias(euroGame)
        addCategorias(dungeonCrawler)
        addCategorias(partyGames)
        addCategorias(deckBuilder)
        addCategorias(ameriTrash)
        addCategorias(thematicGames)
        addEditorial(devir)
        addEditorial(asmodee)
        addEditorial(edge)
        addEditorial(ludonova)
        addEditorial(malditoGames)

    }
    fun addCategorias (categorias: Categorias){
        for (juego in DataHolder.allGames){
            if (juego.categories == categorias){
                categorias.boardGames.add(juego)
            }
        }
    }
    fun addEditorial (categorias: Editorial){
        for (juego in DataHolder.allGames){
            if (juego.editorial == categorias){
                categorias.boardGames.add(juego)
            }
        }
    }


}

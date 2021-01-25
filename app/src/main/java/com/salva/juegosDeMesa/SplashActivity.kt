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
import org.json.JSONObject
import render.animations.*
import kotlin.math.abs


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
                if (db.currentUser != null) {
                    startActivity(Intent(this, HomeActivity::class.java))

                } else {
                    startActivity(Intent(this, MainActivity::class.java))

                }
                finish()
            }, 700)
        }, 1000)

    }

    fun logoEndAnimation() {
        val render = Render(this)
        render.setAnimation(Fade().Out(bgg))
        render.setDuration(600)
        render.start()
    }

    fun startAnimation() {
        val render = Render(this)
        render.setAnimation(Attention().Tada(bgg))
        render.setDuration(900)
        render.start()
    }

    fun initData() {
        if (DataHolder.allGames.isEmpty()) {


            val devir =
                Editorial(
                    "Devir",
                    "https://juegosdelamesaredonda.com/c/147-category_default/devir.jpg"
                )
            val malditoGames = Editorial(
                "Maldito Games",
                "https://juegosdelamesaredonda.com/c/176-category_default/maldito-games.jpg"
            )
            val edge = Editorial(
                "Edge",
                "https://juegosdemesayrol.com/wp-content/uploads/Cabecera-categoria-editorial-Edge-Entertainment.jpg"
            )
            val ludonova = Editorial(
                " Ludonova",
                "https://i0.wp.com/www.elclubdante.es/wp-content/uploads/2018/10/logo_ludonova_FINAL.jpg"
            )
            val fantasyFlighGames = Editorial(
                "Fantasy Flight Games",
                "https://www.chollers.com/img/brands/fantasy-flight-games.jpg"
            )
            val twoTomatoes = Editorial(
                "Two tomatoes games",
                "https://pbs.twimg.com/profile_images/1255150076722176001/UQ60Th51_400x400.jpg"
            )
            val asmodee =
                Editorial(
                    "Asmodee",
                    "https://maltedmeeple.com/wp-content/uploads/2017/01/Asmodee-Logo.png"
                )
            val otros = Editorial(
                "Otros",
                "https://i2.wp.com/menteshexagonadas.com/wp-content/uploads/2017/01/Geek_Head.jpg?fit=500%2C500"
            )
            val euroGame = Categorias(
                "Eurogames"

            )
            val dungeonCrawler = Categorias(
                "Dungeon crawler"

            )
            val estrategia = Categorias(
                "Estrategia"
            )
            val abstractos = Categorias(
                "Abstracto"
            )
            val cooperativo = Categorias(
                "Cooperativos"
            )
            val deckBuilder = Categorias(
                "Juegos de cartas"
            )
            val thematicGames = Categorias(
                "Juegos temáticos"
            )
            val partyGames = Categorias(
                "Party Games"
            )
            val ameriTrash = Categorias(
                "Ameritrash"
            )
            val catan = JuegosDeMesa(
                "Catan",
                "https://images-na.ssl-images-amazon.com/images/I/51iYSRyQF2L._AC_.jpg",
                "Catan es un juego de mesa para toda la familia que se ha convertido en un fenómeno mundial. Desde su aparición en Alemania ha vendido más que muchos de los juegos más tradicionales. Se trata de un juego que aúna la estrategia, la astucia y la capacidad para negociar y en el que los jugadores tratan de colonizar una isla, Catán, rica en recursos naturales. Construyendo pueblos, estableciendo rutas comerciales, etc… Catan ha vendido más de 2 millones de ejemplares en Europa y América. Por si esto no fuera bastante, ha sido galardonado en Alemania y Estados Unidos como Juego del Año. El juego básico de Catan, a la venta desde hace más de 10 años en España, ha marcado un hito en toda Europa en cuanto a juego de planificación, colaboración y, por supuesto, diversión. No hace falta comentar que es la única pieza indispensable de Catan en tu ludoteca. A partir del básico se abre todo el abanico de expansiones que la isla de Catán te ofrece.",
                devir,
                3,
                4,
                euroGame,
                75,
                "3t0BVFjhhCA"
            )
            val stoneAge = JuegosDeMesa(
                "Stone Age",
                "https://zavers.es/7550-large_default/juegos171.jpg",
                "Cada Era presenta unos retos específicos. La Edad de Piedra se caracterizó por el desarrollo de la agricultura, la manipulación de algunos recursos y la construcción de cabañas sencillas. Con la aparición del comercio, empieza también la expansión demográfica, los asentamientos y el desarrollo de las civilizaciones. Además, ciertas habilidades tradicionales, como la destreza en la caza, son muy apreciadas y demandadas, aunque solo sea para poder asegurar el crecimiento de la población. El objetivo de los jugadores será conseguir afrontar y superar estos desafíos. Habrá varias formas de lograrlo, así que cada uno puede intentar hacerlo a su modo. Elige un camino y podrás saber, al final de la partida, si has hecho la mejor elección.",
                devir,
                2,
                4,
                euroGame,
                90,
                "xOMLxecYr6U"
            )
            val terraforming = JuegosDeMesa(
                "Terraforming mars",
                "https://dragonesylosetas.com/wp-content/uploads/2019/07/terraforminsmarsdesp-300x300.jpg",
                "En Terraforming Mars, los jugadores desarrollan el rol de una corporación con un perfil determinado y trabajan juntos en el proceso de terraformación, pero compiten por obtener los puntos de victoria que otorgan no solo tus contribuciones a Marte, sino también las mejoras de la infraestructura humana a través del sistema solar. Al comienzo de cada ronda (llamadas “generaciones”), adquirirán cartas de proyecto únicas (de un mazo con más de 200), mediante las cuales podrán hacer acciones muy variadas: desde introducir nuevas especies de vida vegetal o animal, hasta lanzar asteroides a la superficie marciana, construir ciudades o minar las lunas de Júpiter para extraer valiosos recursos (acero, titanio, energía…). Los Proyectos Estándar también permiten a los jugadores terraformar Marte independientemente de los proyectos que se adquieran.",
                malditoGames,
                1,
                5,
                euroGame,
                120,
                "LNjNIO14fjY"
            )
            val arcadia = JuegosDeMesa(
                "Arcadia Quest",
                "https://ksr-ugc.imgix.net/assets/011/654/850/dc72e74864abd004ca6857a63a70a899_original.jpg?ixlib=rb-2.1.0&crop=faces&w=1552&h=873&fit=crop&v=1463686321&auto=format&frame=1&q=92&s=95718e6b3d7e802815cbfad5614fcb90",
                "En Arcadia Quest, los jugadores crean sus Gremios con 3 de los 12 Héroes disponibles, cada uno de ellos con sus propias capacidades únicas. A medida que avanzan en una campaña llena de ramificaciones y liberan los barrios de Arcadia de los monstruos que los ocupan, los Héroes obtienen nuevas armas, capacidades y objetos mágicos. Los jugadores combinan el botín obtenido con las capacidades innatas de sus Héroes para hacer de su Gremio el más poderoso de Arcadia",
                edge,
                2,
                4,
                dungeonCrawler,
                60,
                "gjk0rZhp8fo"

            )
            val orquesta = JuegosDeMesa(
                "Orquesta negra : Hitler debe morir",
                "https://www.unplugandplay.co/1608-medium_default/orquesta-negra-hitler-debe-morir.jpg",
                "Orquesta Negra es un juego puramente cooperativo en el que cada jugador encarnará a uno de los conspiradores de ese grupo y entre todos intentarán acabar con la vida de Hitler para evitar el colapso de Alemania y salvar el mayor número de vidas posibles, pero la tarea no será fácil pues el tiempo apremia y la Gestapo estrecha su cerco sobre los conspiradores.",
                ludonova,
                1,
                6,
                cooperativo,
                90,
                "j0AVh2gdxd0"
            )

            val timesUp = JuegosDeMesa(
                "Time's up",
                "https://jcsatanas.fr/wp-content/uploads/2015/03/Times-up-version-bleue-et-jaune.jpg",
                "Time’s Up! es un party game por equipos donde trataréis de dar pistas a vuestro compañero o compañeros de equipo para adivinar un personaje histórico o de ficción. Antes de que el juego comience, se reparten las cartas entre los jugadores que tendrán que hacer una selección. Todas las cartas se barajan juntas formando un mazo para ambos equipos.",
                asmodee,
                4,
                12,
                partyGames,
                40,
                "isozRYpR7Yw"
            )
            val dominion = JuegosDeMesa(
                "Dominion",
                "https://images-na.ssl-images-amazon.com/images/I/51L6ePmYmPL._AC_.jpg",
                "Con un amplio listado de premios internacionales, Dominion destaca por su sorprendente sistema de reglas, considerado como la piedra fundacional de los llamados Juegos de Mazos Construibles. (Deck Building Games en inglés)\n" +
                        "\n" +
                        "En Dominion cada jugador posee un Reino (su mazo inicial) y unas inevitables ganas de aumentar sus recursos, objetivo que no es fácil de alcanzar cuando hay tres o cuatro jugadores que tienen los mismos planes.\n" +
                        "\n" +
                        "A diferencia de los juegos de mesa y cartas tradicionales, aquí cada participante debe elaborar su mazo y su estrategia a lo largo de la partida. Con un total de 500 cartas de diferentes tipos (Tesoro, Victoria, Reino y Maldición), una parte de ellas constituyen los suministros que son instalados sobre la mesa (los territorios por dominar y los recursos necesarios para hacerlo); luego, cada jugador comienza la partida con un mazo de diez cartas, con las cuales deberá comprar los diferentes suministros que le permitirán llevar a cabo sus planes y acrecentar sus puntos de Victoria.\n" +
                        "\n" +
                        "De esta manera, los jugadores deberán luchar por lograr la mayor cantidad de puntos de Victoria en su reino para ganar la partida.",
                devir,
                2,
                4,
                deckBuilder,
                30,
                "Mji3s_r1kIE"
            )
            val twilighStraguel = JuegosDeMesa(
                "Twilight Struggle",
                "https://tablerum.com/sites/tablerumcom/files/styles/people_346x346/public/TwilightStruggleCaja.jpg?itok=5L8LI1LI",
                "Eres un amante de las pelis sobre la Guerra Fría? ¿de las historias de espías en plena era del Telón de Acero? ¿de los documentales sobre las intrigas en uno de los conflictos históricos velados pero de mayor intensidad que ha tenido lugar en la historia de la humanidad? Nosotros sí, y este juego nos apasiona -no podía ser de otro modo-.\n" +
                        "\n" +
                        "Twilight Struggle es un juego de tablero temático ambientado en plena Guerra Fría para dos jugadores, uno de ellos representará a Estados Unidos, el otro y como puede preverse a la Unión Soviética, el lance entre estos dos gigantes consigue reflejarse a las mil maravillas con la mecánica del juego.\n" +
                        "\n" +
                        "El objetivo de este juego de mesa no es otro que alcanzar los 20 puntos, pero el marcador es el mismo para los dos jugadores: -20 para soviéticos, +20 para estadounidenses; es decir, que nos hallamos en un coninuo «tira y afloja».",
                devir,
                2,
                2,
                ameriTrash,
                180,
                "g3oA7t2KUIg"
            )
            val jungleSpeed = JuegosDeMesa(
                "Jungle Speed",
                "https://images-na.ssl-images-amazon.com/images/I/819AAgzFlfL._AC_SL1417_.jpg",
                "Jungle Speed es un juego de velocidad y reflejos, en el que cada jugador tendrá que deshacerse de sus cartas para ganar. Se reparten todas las cartas entre los jugadores y por turnos, levantan sus cartas de una en una, lo más rápidamente posible. Si dos (o más) rivales tienen la misma carta, tendrán que coger el tótem, situado en el centro",
                asmodee,
                2,
                10,
                partyGames,
                15,
                "GmKVmEbLa_M"
            )
            val mansiones = JuegosDeMesa(
                "Mansiones de la locura (segunda edicion)",
                "https://cf.geekdo-images.com/imagepage/img/RQczXB_n7UIvTK_U1RQPkKZ2GFk=/fit-in/900x600/filters:no_upscale()/pic3115634.png",
                "La puerta está abierta.\n" +
                        "\n" +
                        "En los sórdidos callejones y las ominosas mansiones de Arkham se ocultan fuerzas arcanas, secretos aterradores y monstruos indescriptibles. Sectarios y demás lunáticos conspiran en el interior de estos antiguos edificios para convocar a los Primigenios, y bajo la luz de la luna acechan bestias desconocidas por los eruditos mortales. Esta noche, un puñado de valerosos investigadores se aventuran tras las puertas cerradas de Arkham para presentar batalla contra la locura que encierran en su interior...\n" +
                        "\n" +
                        "Las Mansiones de la Locura es un juego de tablero de horror y misterio totalmente cooperativo. De 1 a 5 jugadores asumen el papel de los investigadores que se adentran en las oscuras estancias de las mansiones embrujadas de Arkham y en otros lugares igualmente siniestros para desvelar secretos extraños, resolver ingeniosos rompecabezas y enfrentarse a peligros surgidos de otros mundos. Las Mansiones de la Locura también incluye un kit de conversión para que los propietarios de la primera edición del juego puedan utilizar sus investigadores, monstruos y módulos de tablero en esta nueva edición.",
                fantasyFlighGames,
                1,
                5,
                dungeonCrawler,
                180,
                "OzMVPbhogTs"

            )
            val pandemic = JuegosDeMesa(
                "Pandemic legacy",
                "https://cf.geekdo-images.com/imagepage/img/sLDZNl64jb1CErjwMH-UfSjd55A=/fit-in/900x600/filters:no_upscale()/pic2488668.png",
                "Pandemic Legacy es un juego de campaña cooperativo, con un arco de historia general que se juega a través de 12-24 sesiones, dependiendo de qué tan bien le vaya a su grupo en el juego. Al principio, el juego comienza de manera muy similar a la Pandemia básica, en la que su equipo de especialistas en lucha contra enfermedades corre contra el reloj para viajar alrededor del mundo, tratando puntos críticos de enfermedades mientras investiga curas para cada una de las cuatro plagas antes de que se salgan de control.\n" +
                        "\n" +
                        "Durante el turno de un jugador, tienen cuatro acciones disponibles, con las que pueden viajar por el mundo de varias maneras (a veces necesitan descartar una carta), construir estructuras como estaciones de investigación, tratar enfermedades (eliminar un cubo del tablero; si es que todos se han eliminado los cubos de un color, se ha erradicado la enfermedad), se intercambian cartas con otros jugadores o se encuentra una cura para una enfermedad (que requiere que se descarten cinco cartas del mismo color en una estación de investigación). Cada jugador tiene un papel único con habilidades especiales para ayudarlos en estas acciones.",
                devir,
                2,
                4,
                cooperativo,
                60 ,
                "TPX7qTcar18"
            )
            val laton = JuegosDeMesa(
                "Brass: Birmingham",
                "https://images-eu.ssl-images-amazon.com/images/I/416qEn64dLL.jpg",
                "Brass: Birmingham es una continuación del juego de estrategia económica de la obra maestra de Martin Wallace en 2007, Brass . Birmingham cuenta la historia de empresarios competidores en Birmingham durante la revolución industrial, entre los años 1770-1870.\n" +
                        "\n" +
                        "Como en su predecesor, debe desarrollar, construir y establecer sus industrias y redes, en un esfuerzo por explotar las demandas bajas o altas del mercado."
                , malditoGames,
                2,
                4,
                ameriTrash,
                120 ,
                "l-R6yKdpVFM"
            )
            val twilightImperium = JuegosDeMesa(
                "Twilight Imperium",
                "https://cf.geekdo-images.com/imagepage/img/yUt0OX_bXz0ZAerK-d5pTwiy8MA=/fit-in/900x600/filters:no_upscale()/pic3690827.png",
                "Twilight Imperium (Cuarta edición) es un juego de conquista galáctica en el que tres o seis jugadores asumen el papel de una de las diecisiete facciones que compiten por el dominio galáctico a través del poder militar, las maniobras políticas y la negociación económica. Cada facción ofrece una experiencia de juego completamente diferente, desde los fantasmas de Creuss que saltan agujeros de gusano hasta los Emiratos de Hacan, maestros del comercio y la economía. A estas diecisiete razas se les ofrecen muchos caminos hacia la victoria, pero solo una puede sentarse en el trono de Mecatol Rex como los nuevos maestros de la galaxia.\n" +
                        "\n" +
                        "No hay dos partidas de Twilight Imperium que sean idénticos. Al comienzo de cada era galáctica, el tablero de juego se construye de manera única y estratégica utilizando 51 mosaicos de galaxias que cuentan con todo, desde exuberantes planetas y supernovas hasta campos de asteroides y grietas de gravedad. Los jugadores reciben una mano de estas fichas y se turnan para crear la galaxia alrededor de Mecatol Rex, el planeta capital sentado en el centro del tablero. Una tormenta de iones puede impedir que tu raza progrese a través de la galaxia, mientras que una grieta de gravedad colocada fortuitamente puede protegerte de tus enemigos más cercanos. La galaxia es tuya para crear y dominar.",
                fantasyFlighGames,
                3,
                6,
                estrategia,
                480,
                "J9CJX0koouw&t"
            )
            val starWarsRebelion = JuegosDeMesa(
                "Star Wars : Rebellion",
                "https://cf.geekdo-images.com/imagepage/img/0dNGA2gNqxzNWG-bmqrC2BbRaws=/fit-in/900x600/filters:no_upscale()/pic2737530.png",
                "Experimenta la Guerra Civil Galáctica como nunca antes. En Rebellion , controlas todo el Imperio Galáctico o la incipiente Alianza Rebelde. Debes comandar naves espaciales, tener en cuenta los movimientos de tropas y los sistemas de concentración para tu causa. Dadas las diferencias entre el Imperio y la Alianza Rebelde, cada lado tiene diferentes condiciones de victoria, y tendrás que ajustar tu estilo de juego según a quién representes:\n" +
                        "Como jugador Imperial, puedes comandar legiones de Stormtroopers, enjambres de TIE, Star Destroyers e incluso la Estrella de la Muerte. Gobiernas la galaxia por miedo, confiando en el poder de tu ejército masivo para hacer cumplir tu voluntad. Para ganar el juego, debes eliminar la incipiente Alianza Rebelde encontrando su base y arrasándola. En el camino, puedes subyugar mundos o incluso destruirlos.\n" +
                        "Como jugador rebelde, puedes comandar docenas de soldados, aerodeslizadores T-47, corbetas corellianas y escuadrones de combate. Sin embargo, estas fuerzas no son rival para el ejército imperial. En términos de fuerza bruta, se encontrará claramente superado desde el principio, por lo que deberá reunir los planetas para unirse a su causa y ejecutar ataques militares dirigidos para sabotear los patios de construcción imperiales y robar valiosa inteligencia. Para ganar la Guerra Civil Galáctica, deberás influir en los ciudadanos de la galaxia a tu causa. Si sobrevives el tiempo suficiente y fortaleces tu reputación, inspiras a la galaxia a una revuelta a gran escala y ganas.\n" +
                        "Con más de 150 miniaturas de plástico y dos tableros de juego que representan treinta y dos de los sistemas más notables de la galaxia de Star Wars , Rebellion presenta un alcance que es tan grande y amplio como cualquier juego de Star Wars anterior.",
                fantasyFlighGames,
                2,
                4,
                thematicGames,
                240,
                "EY935QqZHG8"
            )
            val gaiaproject = JuegosDeMesa(
                "Gaia Project",
                "https://www.pandagame.es/img/p/2/9/29-large_default.jpg",
                "Gaia Project es un nuevo juego en la línea de Terra Mystica . Al igual que en el Terra Mystica original, catorce facciones diferentes viven en siete tipos diferentes de planetas, y cada facción está unida a sus propios planetas de origen, por lo que para desarrollarse y crecer, deben terraformar los planetas vecinos en sus entornos de origen en competencia con los otros grupos . Además, los planetas Gaia pueden ser utilizados por todas las facciones para la colonización, y los planetas transdimensionales pueden transformarse en planetas Gaia.\n" +
                        "\n" +
                        "Todas las facciones pueden mejorar sus habilidades en seis áreas diferentes de desarrollo: terraformación, navegación, inteligencia artificial, formación, economía, investigación, lo que lleva a tecnología avanzada y bonificaciones especiales. Para hacer todo eso, cada grupo tiene habilidades y habilidades especiales.\n" +
                        "\n" +
                        "El área de juego está compuesta por diez sectores, lo que permite una configuración variable y, por lo tanto, un valor de reproducción aún mayor que su predecesor Terra Mystica . Un juego de dos jugadores está alojado en siete sectores.",
                malditoGames,
                1,
                4,
                ameriTrash,
                150,
                "PezXrfGoSms"
            )
            val trhoughTheAges = JuegosDeMesa(
                "Through the ages",
                "https://images-na.ssl-images-amazon.com/images/I/91iCOG7DLCL._AC_SX355_.jpg",
                "Through the Ages es un juego de construcción de civilizaciones. Cada jugador intenta construir la mejor civilización a través de una gestión cuidadosa de los recursos, descubriendo nuevas tecnologías, eligiendo a los líderes adecuados, construyendo maravillas y manteniendo un ejército fuerte. La debilidad en cualquier área puede ser explotada por tus oponentes. El juego tiene lugar a lo largo de las edades, comenzando en la era de la antigüedad y terminando en la era moderna.",
                devir,
                2,
                4,
                ameriTrash,
                120,
                "PyCV7qCdBHc"
            )
            val greatWesternTrail = JuegosDeMesa(
                "Great Western Trail",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSZ7SvCrUz6C1cVmx8y3C7MI79-eVCPgEv6tj-mghcoPFOS0i4s&usqp=CAU",
                "América en el siglo XIX: eres un ganadero y pastoreas repetidamente tu ganado desde Texas a Kansas City, donde los envías en tren. Esto te gana dinero y puntos de victoria. No hace falta decir que cada vez que llegas a Kansas City, quieres llevar a tu ganado más valioso. Sin embargo, el \"Great Western Trail\" no solo requiere que mantengas a tu rebaño en buena forma, sino también que uses sabiamente los diversos edificios a lo largo del camino. Además, podría ser una buena idea contratar personal capacitado: vaqueros para mejorar su rebaño, artesanos para construir sus propios edificios o ingenieros para la importante línea de ferrocarril.\n" +
                        "\n" +
                        "Si manejas hábilmente tu rebaño y navegas por las oportunidades y trampas de Great Western Trail , seguramente obtendrás la mayor cantidad de puntos de victoria y ganarás el juego.",
                otros,
                2,
                4,
                euroGame,
                150,
                "xJ5Cq8dS48Y"


            )
            val guerraDelAnillo = JuegosDeMesa(
                "Guerra del anillo (segunda edición)",
                "https://images-na.ssl-images-amazon.com/images/I/91VSz8DsatL._AC_SX355_.jpg",
                "En Guerra del anillo , un jugador toma el control de los Pueblos Libres (FP), el otro jugador controla Shadow Armies (SA). Inicialmente, las Naciones del Pueblo Libre son reacias a tomar las armas contra Sauron, por lo que deben ser atacadas por Sauron o persuadidas por Gandalf u otros Compañeros, antes de comenzar a luchar adecuadamente: esto está representado por la Pista Política, que muestra si una Nación es Listo para pelear en la Guerra del Anillo o no.\n" +
                        "\n" +
                        "El juego se puede ganar con una victoria militar, si Sauron conquista un cierto número de ciudades y fortalezas de Gente Libre o viceversa. Pero la verdadera esperanza de los Pueblos Libres radica en la búsqueda del Portador del Anillo: mientras los ejércitos chocan en la Tierra Media, la Comunidad del Anillo está tratando de llegar secretamente al Monte del destino para destruir el Anillo Único. Sauron no es consciente de la verdadera intención de sus enemigos, pero está buscando a través de la Tierra Media el precioso Anillo, por lo que la Comunidad se enfrentará a numerosos peligros, representados por las reglas de La caza del anillo. Pero los Compañeros pueden estimular a los Pueblos Libres a luchar contra Sauron, por lo que el jugador de los Pueblos Libres debe equilibrar la necesidad de proteger al Portador del Anillo del daño, contra el intento de levantar una defensa adecuada contra los ejércitos de la Sombra,",
                devir,
                2,
                4,
                thematicGames,
                180,
                "ScpE7RqtacU"
            )
            val scythe = JuegosDeMesa(
                "Scythe",
                "https://th.bing.com/th/id/R24749145252e3b87d6e26866a9e07a73?rik=WDfQdjNCj6%2b5XA&riu=http%3a%2f%2flamparamagica-shop.com%2fwp-content%2fuploads%2f2017%2f04%2fcomprar-scythe-promos.jpeg&ehk=j5B2pw2AkmEaOGwcPeCDhYIl5d16oDPM33QGPYeuDuY%3d&risl=&pid=ImgRaw",
                "Es una época de disturbios en la Europa de 1920. Las cenizas de la primera gran guerra todavía oscurecen la nieve. La ciudad-estado capitalista conocida simplemente como \"La Fábrica\", que alimentó la guerra con mechs fuertemente blindados, ha cerrado sus puertas, llamando la atención de varios países cercanos.\n" +
                        "\n" +
                        "Scythe es un juego de construcción de motores ambientado en un período de la década de 1920 de historia alternativa. Es una época de agricultura y guerra, corazones rotos y engranajes oxidados, innovación y valor. En Scythe , cada jugador representa un personaje de una de las cinco facciones de Europa del Este que intentan ganar su fortuna y reclamar la participación de su facción en la tierra alrededor de la misteriosa Fábrica. Los jugadores conquistan territorios, reclutan nuevos reclutas, cosechan recursos, ganan aldeanos, construyen estructuras y activan monstruosos mechs.",
                malditoGames,
                1,
                5,
                euroGame,
                115,
                "BmSGt3Pq6Z8"
            )
            val castillosDeBorgona = JuegosDeMesa(
                "Los castillos de borgoña",
                "https://www.planetongames.com/19558-thickbox_default/los-castillos-de-borgona.jpg",
                "El juego se desarrolla en la región de Borgoña de la Alta Francia medieval. Cada jugador asume el papel de un aristócrata, controlando originalmente un pequeño principado. Mientras juegan, su objetivo es construir asentamientos y poderosos castillos, practicar el comercio a lo largo del río, explotar minas de plata y utilizar el conocimiento de los viajeros.\n" +
                        "\n" +
                        "El juego se trata de jugadores que toman fichas de asentamiento del tablero de juego y las colocan en su princedom que está representado por el tablero de jugador. Cada mosaico tiene una función que comienza cuando el mosaico se coloca en el princedom. El propio principado consta de varias regiones, cada una de las cuales exige su propio tipo de mosaico de asentamiento.",
                malditoGames,
                2,
                4,
                euroGame,
                90,
                "8F_hMT-iCEc"
            )
            val terraMystica = JuegosDeMesa(
                "Terra mystica",
                "https://images-na.ssl-images-amazon.com/images/I/51YN33OMBIL._AC_.jpg",
                "En la tierra de Terra Mystica habitan 14 personas diferentes en siete paisajes, y cada grupo está vinculado a su propio entorno familiar, por lo que para desarrollarse y crecer, deben terraformar los paisajes vecinos en sus entornos domésticos en competencia con los otros grupos.\n" +
                        "\n" +
                        "Terra Mystica es un juego de información completa sin suerte que premia la planificación estratégica. Cada jugador gobierna uno de los 14 grupos. Con sutileza y habilidad, el jugador debe intentar gobernar un área tan grande como sea posible y desarrollar las habilidades de ese grupo. También hay cuatro cultos religiosos en los que puedes progresar. Para hacer todo eso, cada grupo tiene habilidades y destrezas especiales.",
                devir,
                2,
                5,
                euroGame,
                150,
                "E17QM0wVACU"
            )
            val arkhamHorror = JuegosDeMesa(
                "Arkham horror : el juego de cartas",
                "https://images-na.ssl-images-amazon.com/images/I/71zTk1TN%2BhL._AC_SL1024_.jpg",
                "Algo malo se agita en Arkham, y solo tú puedes detenerlo. ¡Borrando las líneas tradicionales entre el juego de roles y las experiencias de juegos de cartas, Arkham Horror: The Card Game es un juego de cartas viviente de misterio, monstruos y locura de Lovecraft!\n" +
                        "\n" +
                        "En el juego, tú y tu amigo (o hasta tres amigos con dos conjuntos principales) se convierten en personajes de la tranquila ciudad de Arkham, en Nueva Inglaterra. Tienes tus talentos, claro, pero también tienes tus defectos. Tal vez has incursionado demasiado en los escritos del Necronomicon, y sus palabras continúan obsesionándote. Tal vez te sientas obligado a ocultar cualquier signo de maldad de otro mundo, obstaculizando tus propias investigaciones para proteger la tranquilidad de la población en general. Tal vez te asusten tus encuentros con un culto macabro.\n" +
                        "\n" +
                        "No importa lo que te atraiga, no importa lo que te persiga, encontrarás tus fortalezas y debilidades reflejadas en tu mazo de cartas personalizado, y estas cartas serán tus recursos mientras trabajas con tus amigos para desentrañar los misterios más terroríficos del mundo.",
                fantasyFlighGames,
                1,
                2,
                deckBuilder,
                120,
                "AlW6dl_ZsRg"
            )
            val wingspawn = JuegosDeMesa(
                "Wingspan",
                "https://www.planetongames.com/23020-thickbox_default/wingspan.jpg",
                "Wingspan es un juego de mesa competitivo, de peso medio, impulsado por cartas y de construcción de motores de Stonemaier Games.\n" +
                        "\n" +
                        "Ustedes son entusiastas de las aves (investigadores, observadores de aves, ornitólogos y recolectores) que buscan descubrir y atraer las mejores aves a su red de reservas de vida silvestre. Cada pájaro extiende una cadena de combinaciones poderosas en uno de sus hábitats (acciones). Estos hábitats se centran en varios aspectos clave del crecimiento:\n" +
                        "\n" +
                        "Gana fichas de comida a través de dados personalizados en una torre de dados para comederos de pájaros\n" +
                        "Pon huevos usando miniaturas de huevos en una variedad de colores.\n" +
                        "Roba de cientos de cartas de aves únicas y juega\n" +
                        "El ganador es el jugador con más puntos después de 4 rondas.\n" +
                        "\n" +
                        "Si disfrutas Terraforming Mars y Gizmos , creemos que este juego tomará vuelo en tu mesa.",
                malditoGames,
                1,
                5,
                euroGame,
                70,
                "k-Q1565_Y-8"
            )
            val viticulture = JuegosDeMesa(
                "Viticulture",
                "https://images-na.ssl-images-amazon.com/images/I/512otWrymBL.__AC_SY300_QL70_ML2_.jpg",
                "En Viticultura, los jugadores se encuentran en el papel de personas en la Toscana rústica y premoderna que han heredado viñedos exiguos. Tienen algunas parcelas de tierra, un viejo crushpad, una pequeña bodega y tres trabajadores. Cada uno de ellos sueña con ser el primero en llamar a su bodega un verdadero éxito.\n" +
                        "\n" +
                        "Los jugadores están en posición de determinar cómo quieren asignar a sus trabajadores durante todo el año. Cada temporada es diferente en un viñedo, por lo que los trabajadores tienen diferentes tareas que pueden realizar en verano e invierno. Hay competencia sobre esas tareas y, a menudo, el primer trabajador en llegar al trabajo tiene una ventaja sobre los trabajadores posteriores.\n" +
                        "\n" +
                        "Afortunadamente para los jugadores, a la gente le encanta visitar las bodegas, y sucede que muchos de esos visitantes están dispuestos a ayudar alrededor del viñedo cuando visitan, siempre y cuando asignes un trabajador para que los cuide. Sus visitas (en forma de tarjetas) son breves pero pueden ser muy útiles.",
                malditoGames,
                1,
                6,
                euroGame,
                90,
                "Manz-8dk8nQ"
            )
            val puertoRico = JuegosDeMesa(
                "Puerto rico",
                "https://devir.cl/wp-content/uploads/2017/06/puerto-rico-abierto.jpg",
                "En Puerto Rico, los jugadores asumen los roles de gobernadores coloniales en la isla de Puerto Rico. El objetivo del juego es acumular puntos de victoria enviando productos a Europa o construyendo edificios.\n" +
                        "\n" +
                        "Cada jugador usa un tablero pequeño separado con espacios para edificios, plantaciones y recursos de la ciudad. Compartidos entre los jugadores hay tres naves, una casa comercial y un suministro de recursos y doblones.\n" +
                        "\n" +
                        "El ciclo de recursos del juego es que los jugadores cultivan cosechas que intercambian por puntos o doblones. Los doblones se pueden usar para comprar edificios, lo que permite a los jugadores producir más cultivos o darles otras habilidades. Los edificios y las plantaciones no funcionan a menos que sean atendidos por colonos.",
                devir,
                3,
                5,
                euroGame,
                150,
                "ONXRQw0acck"
            )
            val caverna = JuegosDeMesa(
                "Caverna",
                "https://devir.cl/wp-content/uploads/2017/06/caverna-abierto.jpg",
                "Siguiendo la misma línea que su predecesor ( Agricola ), Caverna: The Cave Farmers es un juego de colocación de trabajadores en el fondo, con un enfoque en la agricultura. En el juego, eres el líder barbudo de una pequeña familia enana que vive en una pequeña cueva en las montañas. Comienzas el juego con un granjero y su cónyuge, y cada miembro de la familia de agricultores representa una acción que el jugador puede tomar en cada turno. Juntos, cultivas el bosque frente a tu cueva y cavas más profundo en la montaña. Usted proporciona las cuevas como viviendas para su descendencia, así como espacios de trabajo para pequeñas empresas.\n" +
                        "\n" +
                        "Depende de usted cuánto mineral quiere extraer. Lo necesitarás para forjar armas que te permitan realizar expediciones para obtener objetos y acciones adicionales. Mientras cava a través de la montaña, puede encontrar fuentes de agua y encontrar minas de mineral y rubí que lo ayudan a aumentar su riqueza. Justo en frente de tu cueva, puedes aumentar tu riqueza aún más con la agricultura: puedes cortar el bosque para sembrar campos y cercar los pastos para mantener a tus animales. También puede expandir a su familia mientras administra su granja en constante crecimiento. Al final, el jugador con el tablero local más eficientemente desarrollado gana.\n" +
                        "la duracion estimada es de 30 minutos por jugador",
                devir,
                1,
                7,
                euroGame,
                30,
                "HJen0z3B6Lo"
            )
            val agricola = JuegosDeMesa(
                "Agricola",
                "https://estaticos1.kubekings.com/13599-medium_default/devir-agricola-juego-de-mesa.jpg",
                "En Agricola , eres un granjero en una cabaña de madera con tu cónyuge y poco más. En un turno, puedes realizar solo dos acciones, una para ti y otra para el cónyuge, de todas las posibilidades que encontrarás en una granja: recolectar arcilla, madera o piedra; construcción de cercas; y así. Puede pensar en tener hijos para lograr más trabajo, pero primero necesita expandir su casa. ¿Y qué vas a alimentar a todos los pequeños rugrats?\n" +
                        "\n" +
                        "El juego admite muchos niveles de complejidad, principalmente a través del uso (o no uso) de dos de sus principales tipos de cartas, Mejoras menores y Ocupaciones. En la versión para principiantes (llamada Variante familiar en el lanzamiento de EE. UU.), Estas tarjetas no se utilizan en absoluto. Para el juego avanzado, el lanzamiento en los Estados Unidos incluye tres niveles de ambos tipos de cartas; Básico (E-deck), Interactivo (I-deck) y Complejo (K-deck), y el libro de reglas alienta a los jugadores a experimentar con los diferentes mazos y mezclas de los mismos. También existen mazos de posventa como el Z-Deck y el L-Deck.\n" +
                        "la duracion estimada es de 30 minutos por jugador",
                devir,
                1,
                5,
                euroGame,
                30,
                "gzdYpIj1s7Y"
            )
            val bloodRage = JuegosDeMesa(
                "Blood Rage",
                "https://images-na.ssl-images-amazon.com/images/I/71m9qKyWdbL._AC_SY355_.jpg",
                "\"La vida es batalla; la batalla es gloria; la gloria es TODO\"\n" +
                        "\n" +
                        "En Blood Rage , cada jugador controla a sus propios guerreros, líderes y barcos del clan Viking. ¡Ragnarök ha llegado y es el fin del mundo! ¡Es la última oportunidad de los vikingos de caer en un resplandor de gloria y asegurar su lugar en Valhalla al lado de Odin! Para un vikingo hay muchos caminos hacia la gloria. Puedes invadir y saquear la tierra para obtener sus recompensas, aplastar a tus oponentes en batallas épicas, completar misiones, aumentar las estadísticas de tu clan o incluso morir gloriosamente en la batalla o en Ragnarök, la perdición definitiva e ineludible.\n" +
                        "\n" +
                        "La mayoría de las estrategias de los jugadores están guiadas por las cartas redactadas al comienzo de cada una de las tres rondas del juego (o Edades). Estos \"Regalos de Dios\" le otorgan numerosas bendiciones para su clan, que incluyen: mayor fuerza vikinga y estrategias de batalla tortuosas, mejoras a su clan o incluso la ayuda de criaturas legendarias de la mitología nórdica. También pueden incluir varias misiones, desde el dominio de provincias específicas, hasta que muchos de tus vikingos sean enviados a Valhalla. La mayoría de estas cartas están alineadas con uno de los dioses nórdicos, insinuando el tipo de estrategia que admiten. Por ejemplo, Thor da más gloria por la victoria en la batalla, Heimdall te otorga previsión y sorpresas, Tyr te fortalece en la batalla, mientras que el embaucador Loki te recompensa por perder batallas o castiga al ganador.",
                edge,
                2,
                4,
                estrategia,
                90,
                "AfxZ9GyFkbU"
            )
            val nemesis = JuegosDeMesa(
                "Nemesis",
                "https://www.spelmagazijn.be/media/seo/2/product/600x600/n/e/nemesis_rebel_games.jpg",
                "Jugar a Nemesis te llevará al corazón del horror de supervivencia de ciencia ficción en todo su terror. Un soldado dispara a ciegas por un pasillo, tratando de detener el avance alienígena. Un científico se apresura a encontrar una solución en su laboratorio improvisado. Un traidor roba la última cápsula de escape en el último momento. Los intrusos que conoces en el barco no solo reaccionan al ruido que haces, sino que también evolucionan a medida que pasa el tiempo. Cuanto más dura el juego, más fuertes se vuelven. Durante el juego, controlas a uno de los miembros de la tripulación con un conjunto único de habilidades, baraja de cartas personal y equipo de arranque individual. Estos héroes cubren todas tus necesidades básicas de horror de SF. Por ejemplo, el científico es excelente con las computadoras y la investigación, pero tendrá dificultades en el combate. El soldado, por otro lado ...\n" +
                        "\n" +
                        "Nemesis es un juego semi-cooperativo en el que tú y tus compañeros de tripulación deben sobrevivir en un barco infestado de organismos hostiles. Para ganar el juego, debes completar uno de los dos objetivos que se te asignaron al comienzo del juego y volver a la Tierra de una pieza. Encontrarás muchos obstáculos en tu camino: enjambres de intrusos (el nombre dado a los organismos extraterrestres por la IA de la nave), el mal estado físico de la nave, las agendas de tus compañeros jugadores y, a veces, solo un destino cruel.\n" +
                        "\n" +
                        "El juego de Nemesis está diseñado para estar lleno de momentos climáticos que, con suerte, encontrarás gratificantes incluso cuando tus mejores planes se arruinen y tu personaje se encuentre con un destino terrible.",
                edge,
                1,
                5,
                dungeonCrawler,
                180,
                "lPiDgeCRvUg"
            )
            val rootJuego = JuegosDeMesa(
                "ROOT",
                "https://images-na.ssl-images-amazon.com/images/I/71KbqL42RhL._AC_SY355_.jpg",
                "Root es un juego de aventura y guerra en el que 2 a 4 (1 a 6 con la expansión 'Riverfolk') los jugadores luchan por el control de un vasto desierto.\n" +
                        "\n" +
                        "La infame Marquesa de Cat se ha apoderado del gran bosque, con la intención de cosechar sus riquezas. Bajo su gobierno, las muchas criaturas del bosque se han unido. Esta alianza buscará fortalecer sus recursos y subvertir el gobierno de los gatos. En este esfuerzo, la Alianza puede contar con la ayuda de los Vagabundos errantes que pueden moverse a través de los caminos forestales más peligrosos. Aunque algunos pueden simpatizar con las esperanzas y los sueños de la Alianza, estos vagabundos son lo suficientemente mayores como para recordar a las grandes aves de presa que alguna vez controlaron el bosque.\n" +
                        "\n" +
                        "Mientras tanto, en el borde de la región, la orgullosa y riñonera Eyrie ha encontrado un nuevo comandante que esperan que lidere a su facción para reanudar su antiguo derecho de nacimiento. El escenario está listo para un concurso que decidirá el destino del gran bosque. Depende de los jugadores decidir qué grupo finalmente arraigará.",
                twoTomatoes,
                2,
                4,
                estrategia,
                90,
                "w6y-kxHMZ_U"
            )
            val altaTension = JuegosDeMesa(
                "Alta tensión",
                "https://www.planetongames.com/2207-large_default/alta-tension.jpg",
                "El objetivo de Alta tensión es suministrar energía a la mayoría de las ciudades cuando la red de alguien gana un tamaño predeterminado. En esta nueva edición, los jugadores marcan rutas preexistentes entre ciudades para conectarse y luego compiten entre sí para comprar las plantas de energía que usan para alimentar sus ciudades.\n" +
                        "\n" +
                        "Sin embargo, a medida que se compran las plantas, las plantas más nuevas y más eficientes están disponibles, por lo que simplemente comprando, potencialmente está permitiendo que otros accedan a equipos superiores.\n" +
                        "\n" +
                        "Además, los jugadores deben adquirir las materias primas (carbón, petróleo, basura y uranio) necesarias para alimentar dichas plantas (a excepción de los parques eólicos / solares 'renovables', que no requieren combustible), lo que hace que sea una lucha constante para actualizar sus plantas para obtener la máxima eficiencia y al mismo tiempo conservar la riqueza suficiente para expandir rápidamente su red para obtener las rutas más baratas.",
                edge,
                2,
                6,
                euroGame,
                120,
                "Oo_-nh-6bT8"
            )
            val imperialAssault = JuegosDeMesa(
                "Star wars : Imperial assault",
                "https://m.media-amazon.com/images/I/71jaVoASmyL._AC_SS350_.jpg",
                "Star Wars: Imperial Assault es un juego de estrategia de combate táctico y misiones para dos a cinco jugadores, que ofrece dos juegos distintos de batalla y aventura en el universo de Star Wars.\n" +
                        "\n" +
                        "Imperial Assault te pone en medio de la Guerra Civil Galáctica entre la Alianza Rebelde y el Imperio Galáctico después de la destrucción de la Estrella de la Muerte sobre Yavin 4. En este juego, tú y tus amigos pueden participar en dos juegos separados. El juego de campaña enfrenta a las ilimitadas tropas y recursos del Imperio Galáctico contra un equipo crack de operativos rebeldes de élite mientras se esfuerzan por romper el dominio del Imperio en la galaxia, mientras que el juego de escaramuza te invita a ti y a un amigo a reunir equipos de ataque y luchar contra la cabeza. enfrentarse a objetivos en conflicto.\n" +
                        "\n" +
                        "En el juego de campaña, Imperial Assault te invita a jugar a través de una historia cinematográfica ambientada en el universo de Star Wars. Un jugador comanda los ejércitos aparentemente ilimitados del Imperio Galáctico, amenazando con extinguir la llama de la Rebelión para siempre. Hasta otros cuatro jugadores se convierten en héroes de la Alianza Rebelde, participando en operaciones encubiertas para socavar los esquemas del Imperio. A lo largo de la campaña, tanto el jugador imperial como los héroes rebeldes obtienen nuevas experiencias y habilidades, lo que permite que los personajes evolucionen a medida que se desarrolla la historia.",
                edge,
                2,
                5,
                thematicGames,
                120,
                "sEk9JB39xg4"
            )
            val tzolkin = JuegosDeMesa(
                "Tzolk'in",
                "https://m.media-amazon.com/images/I/51exfaftwlL._AC_UL320_.jpg" ,
                "Tzolkin: El Calendario Maya presenta un nuevo mecanismo de juego: la colocación dinámica de los trabajadores. Los jugadores que representan a diferentes tribus mayas colocan a sus trabajadores en engranajes gigantes conectados y, a medida que los engranajes giran, llevan a los trabajadores a diferentes puntos de acción.\n" +
                        "\n" +
                        "Durante un turno, los jugadores pueden (a) colocar a uno o más trabajadores en el punto visible más bajo de los engranajes o (b) recoger a uno o más trabajadores. Al colocar a los trabajadores, deben pagar el maíz, que se usa como moneda en el juego. Cuando recogen a un trabajador, realizan ciertas acciones dependiendo de la posición del trabajador. Las acciones ubicadas \"más tarde\" en los engranajes son más valiosas, por lo que es aconsejable dejar que el tiempo trabaje para usted, pero los jugadores no pueden saltarse su turno; Si tienen a todos sus trabajadores en los engranajes, tienen que recoger algunos. \n" +
                        "\n" +
                        "El juego termina después de una revolución completa del equipo central de Tzolkin. Hay muchos caminos hacia la victoria. Complacer a los dioses colocando calaveras de cristal en cuevas profundas o construyendo muchos templos son solo dos de esos muchos caminos ...",
                devir,
                2,
                4,
                euroGame,
                90,
                "pEv0lunE8J0"
            )
            val leHavre = JuegosDeMesa(
                "Le Havre",
                "https://dragonesylosetas.com/wp-content/uploads/2020/03/lehavre32.jpg",
                "En Le Havre , el turno de un jugador consta de dos partes: en primer lugar, distribuir productos recién suministrados en los espacios de oferta; entonces toma una acción. Como acción, los jugadores pueden elegir tomar todos los bienes de un tipo de un espacio de oferta o usar uno de los edificios disponibles. Las acciones de construcción permiten a los jugadores actualizar bienes, venderlos o usarlos para construir sus propios edificios y barcos. Los edificios son tanto una oportunidad de inversión como un flujo de ingresos, ya que los jugadores deben pagar una tarifa de entrada para usar edificios que no son de su propiedad. Los barcos, por otro lado, se utilizan principalmente para proporcionar los alimentos necesarios para alimentar a los trabajadores.\n" +
                        "\n" +
                        "Después de cada siete turnos, la ronda termina: el ganado y los granos de los jugadores pueden multiplicarse a través de una Cosecha, y los jugadores deben alimentar a sus trabajadores. Después de un número fijo de rondas, cada jugador puede llevar a cabo una acción final, y luego el juego termina. Los jugadores agregan el valor de sus edificios y barcos a sus reservas de efectivo. El jugador que ha acumulado la mayor fortuna es el ganador.\n" +
                        "la duración de la partida es de 30 minutos por jugador",
                malditoGames,
                1,
                5,
                euroGame,
                30,
                "-hb-bOreQyw"
            )
            val azul = JuegosDeMesa(
                "Azul " ,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQLjgdqevdOh3ElmSZYd4idmLbUEkCSZG3Rvpcx5WCSB73FkdYN&usqp=CAU",
                "Introducidos por los moros, los azulejos (originalmente baldosas de cerámica blanca y azul) fueron totalmente adoptados por los portugueses cuando su rey Manuel I, en una visita al palacio de la Alhambra en el sur de España, quedó hipnotizado por la impresionante belleza de los azulejos decorativos moros. El rey, asombrado por la belleza interior de la Alhambra, ordenó de inmediato que su propio palacio en Portugal fuera decorado con azulejos similares. Como artista de colocación de azulejos, has sido desafiado a embellecer las paredes del Palacio Real de Évora.\n" +
                        "\n" +
                        "En el juego Azul , los jugadores se turnan para dibujar fichas de colores de los proveedores a su tablero de jugadores. Más adelante en la ronda, los jugadores obtienen puntos en función de cómo han colocado sus fichas para decorar el palacio. Se obtienen puntos adicionales por patrones específicos y series completas; los suministros desperdiciados dañan la puntuación del jugador. El jugador con más puntos al final del juego gana.",
                otros ,
                2 ,
                4 ,
                abstractos ,
                45 ,
                "xW609WKcO7o"
            )
            val marcoPolo = JuegosDeMesa(
                "Los viajes de Marco Polo",
                "https://images-na.ssl-images-amazon.com/images/I/71V3npATo7L._AC_SY355_.jpg",
                "En Los viajes de Marco Polo , los jugadores recrean este viaje, y cada jugador tiene un personaje diferente y un poder especial en el juego. El juego se juega en cinco rondas. Cada ronda, los jugadores lanzan sus cinco dados personales y pueden realizar una acción cada turno con ellos. Las cinco acciones principales se muestran en la parte inferior del tablero:\n" +
                        "\n" +
                        "Obtenga recursos con 1-3 dados, dependiendo del valor del recurso (camellos, pimienta, seda, oro). El primer jugador para cada recurso los obtiene gratis; los posteriores tienen que pagar de acuerdo con el valor que se muestra en los dados.\n" +
                        "Tome un recurso de su elección y dos camellos. Cada jugador establece el valor mínimo para los dados futuros.\n" +
                        "Gana dinero, con cualquiera muere, obteniendo cinco dinero.\n" +
                        "Órdenes de compra: el valor de un dado desbloquea las órdenes hasta ese número (que se muestra en los espacios) y le permite comprar una o dos de esas órdenes. Los pedidos se actualizan y se colocan al comienzo de cada ronda. Para cumplir una orden, los jugadores deben gastar recursos para obtener puntos de victoria, otros recursos, camellos y más.\n" +
                        "Recorrido: se colocan dos dados para desbloquear la distancia que se puede recorrer en la parte superior del tablero, es decir, el mapa. Aquí, la pieza de viajero de cada jugador comienza en Venecia y puede decidir entre varias rutas hacia el este, hasta Beijing. Cuando un viajero se detiene en una ciudad, coloca un marcador allí, dándole acceso a una acción adicional diferente para el resto del juego.\n" +
                        "Después de cinco rondas, el juego termina con los jugadores que reciben puntos de victoria por llegar a Beijing, cumplir la mayoría de las órdenes y haber llegado a las ciudades con tarjetas de ciudades secretas que cada jugador obtiene al comienzo del juego; Estos puntos se suman a los VP ganados durante el juego." ,
                devir ,
                2 ,
                4 ,
                euroGame ,
                100,
                "tGZpxqvfoEU"
            )
            val everdell = JuegosDeMesa(
                "Everdell",
                "https://www.malditogames.com/wp-content/uploads/2019/11/FT_Everdell_sin-400x400.jpg",
                "En el interior del valle encantado de Everdell, bajo las ramas de los imponentes árboles, riachuelos sinuosos y cavidades musgosas, una civilización de criaturas del bosque está floreciendo y expandiéndose. Desde Everfrost hasta Bellsong, los años han ido pasando y ha llegado la hora de asentarse en nuevos territorios y de establecer nuevas ciudades. En Everdell te convertirás en el líder de un grupo de criaturas que intentarán tener éxito en esta misión. Hay edificios que construir, alegres personajes que conocer y eventos que organizar. Tienes un año ajetreado por delante. ¿Brillará más el sol en tu ciudad antes de que la luna del invierno se alce?\n" +
                        "\n" +
                        "Everdell es un juego dinámico de colocación de trabajadores. Coloca tus trabajadores para reunir recursos, conseguir cartas y realizar acciones especiales; y juega cartas que permitirán desarrollar y poblar tu ciudad. Las combinaciones de cartas te permitirán desarrollar numerosas estrategias y tendrás una infinidad de posibilidades para trabajar en tu ciudad. El jugador que construya la ciudad con más puntos antes del siguiente invierno habrá ganado.",
                malditoGames,
                1,
                4,
                euroGame,
                80,
                "NHtMmjM5M2E"
            )
            val robinsonCrusoe = JuegosDeMesa(
                "Robinson Crusoe",
                "https://images-na.ssl-images-amazon.com/images/I/71W5pGSBxgL._AC_SL1024_.jpg",
                "Este juego lleva a los jugadores a una isla desierta, donde interpretarán a los sobrevivientes del naufragio que se enfrentarán a una aventura extraordinaria. Se enfrentarán a los desafíos de construir un refugio, encontrar comida, luchar contra las bestias salvajes y protegerse de los cambios climáticos. Construir muros alrededor de sus hogares, domesticación de animales, construir armas y herramientas a partir de lo que encuentran y mucho más les espera en la isla. Los jugadores deciden en qué dirección se desarrollará el juego y, después de varias semanas de arduo trabajo en el juego, cómo se verá su solución. ¿Lograrán descubrir el secreto de la isla mientras tanto? ¿Encontrarán un tesoro pirata, o un pueblo abandonado? ¿Descubrirán una ciudad subterránea o un templo maldito en el fondo de un volcán? Las respuestas a estas preguntas se encuentran en cientos de tarjetas de eventos y cientos de tarjetas de objetos y estructuras que se pueden usar durante el juego ...",
                edge ,
                1 ,
                4 ,
                cooperativo ,
                120,
                "ayNCIpUF3G0&t"
            )
            val androidNetrunner = JuegosDeMesa(
                "Android netrunner" ,
                "https://images-na.ssl-images-amazon.com/images/I/519CVRT008L._AC_.jpg",
                "Android: Netrunner es un juego de naipes vivos asimétrico para dos jugadores. Ambientado en el futuro cyberpunk de Android e Infiltration , el juego enfrenta una megacorporación y sus enormes recursos contra los talentos subversivos de los corredores solitarios.\n" +
                        "\n" +
                        "Las corporaciones buscan marcar agendas avanzando en ellas. Hacerlo lleva tiempo y créditos. Para comprar el tiempo y ganar los créditos que necesitan, deben proteger sus servidores y fortalezas de datos con \"hielo\". Estos programas de seguridad vienen en diferentes variedades, desde simples barreras, hasta puertas de código y centinelas agresivos. Sirven como los ojos, oídos y ametralladoras virtuales de la corporación en las extensas autopistas de información de la red.\n" +
                        "\n" +
                        "A su vez, los corredores deben gastar su tiempo y créditos en adquirir una riqueza suficiente de recursos, comprar el hardware necesario y desarrollar programas de rompehielos adecuadamente poderosos para piratear las medidas de seguridad corporativas anteriores. Sus trabajos siempre son un poco desesperados, impulsados \u200B\u200Bpor plazos ajustados y envueltos en misterio. Cuando un corredor se conecta y comienza a correr en un servidor corporativo, se arriesga a que sus mejores programas sean destruidos o sean atrapados por un programa de rastreo y sean vulnerables a las contramedidas corporativas. No es raro que un corredor no preparado no pase por alto a un centinela desagradable y sufra un daño cerebral masivo como resultado. Incluso si un corredor supera las defensas de un fuerte de datos, no se sabe qué contiene. A veces, el corredor encuentra algo de valor. Algunas veces,",
                fantasyFlighGames ,
                2 ,
                2 ,
                deckBuilder ,
                45,
                "g82VKxpkBK4&t"

            )
            val anachrony = JuegosDeMesa(
                "Anachrony",
                "https://dqzrr9k4bjpzk.cloudfront.net/images/7699343/1094918038.jpg",
                "Es a finales del siglo 26. La Tierra se está recuperando de una explosión catastrófica que exterminó a la mayoría de la población hace siglos e hizo inhabitable la mayor parte de la superficie debido a las condiciones climáticas sobrenaturales. Los humanos sobrevivientes se organizaron a lo largo de cuatro ideologías radicalmente diferentes, llamadas Caminos, para reconstruir el mundo como mejor les parezca: Armonía, Dominio, Progreso y Salvación. Los seguidores de los cuatro caminos viven en una paz frágil, pero en un aislamiento casi completo uno al lado del otro. Su único punto de encuentro es la última ciudad importante en la Tierra, ahora conocida como la Capital.\n" +
                        "\n" +
                        "Al encender las misteriosas grietas del tiempo que se abrieron a raíz del cataclismo, cada camino puede volver a momentos específicos de su pasado. Hacerlo puede acelerar enormemente su progreso, pero demasiada intromisión puede poner en peligro el continuo espacio-tiempo. Pero el progreso es más importante que nunca antes: si se cree en el misterioso mensaje que llega a través de la Grieta del Tiempo, se avecina un cataclismo aún más terrible en el horizonte: un asteroide con la misteriosa sustancia llamada Neutronium se dirige hacia la Tierra. Aún más extraño, los científicos muestran que la firma energética del asteroide coincide con la explosión hace siglos ...\n" +
                        "\n" +
                        "Anachrony presenta un sistema único de colocación de trabajadores de dos niveles. Para viajar a la Capital o aventurarse a las áreas devastadas en busca de recursos, los jugadores no solo necesitan varios especialistas (Ingenieros, Científicos, Administradores y Genios) sino también Exosuits para protegerlos y mejorarlos, y ambos son escasos.",
                malditoGames ,
                1 ,
                4 ,
                ameriTrash ,
                120,
                "WEMWzLyujSg"
            )
            val sevenWonder = JuegosDeMesa(
                "7 Wonder",
                "https://m.media-amazon.com/images/I/91mmWj3k0KL._AC_UL320_.jpg",
                "Eres el líder de una de las 7 grandes ciudades del mundo antiguo. Reúna recursos, desarrolle rutas comerciales y afirme su supremacía militar. Construye tu ciudad y erige una maravilla arquitectónica que trascenderá los tiempos futuros.\n" +
                        "\n" +
                        "7 maravillas dura tres edades. En cada edad, los jugadores reciben siete cartas de un mazo en particular, eligen una de esas cartas y luego pasan el resto a un jugador adyacente. Los jugadores revelan sus cartas simultáneamente, pagando recursos si es necesario o recolectando recursos o interactuando con otros jugadores de varias maneras. (Los jugadores tienen tableros individuales con poderes especiales para organizar sus cartas, y los tableros son de doble cara). Luego, cada jugador elige otra carta del mazo que se les pasó, y el proceso se repite hasta que los jugadores tengan seis cartas en juego desde esa edad. Después de tres años, el juego termina.\n" +
                        "\n" +
                        "En esencia, 7 Wonders es un juego de desarrollo de cartas. Algunas cartas tienen efectos inmediatos, mientras que otras proporcionan bonificaciones o mejoras más adelante en el juego. Algunas tarjetas ofrecen descuentos en futuras compras. Algunos proporcionan fuerza militar para dominar a tus vecinos y otros no dan más que puntos de victoria. Cada carta se juega inmediatamente después de ser sorteada, para que sepa qué cartas recibe su vecino y cómo sus elecciones pueden afectar lo que ya ha acumulado. Las tarjetas se pasan izquierda-derecha-izquierda durante las tres edades, por lo que debe vigilar a los vecinos en ambas direcciones.",
                asmodee ,
                2,
                7,
                deckBuilder ,
                30,
                "r2ho73DRABQ"
            )
            val keyflower = JuegosDeMesa(
                "Keyflower",
                "https://dungeonmarvels.com/56915-large_default/keyflower-cuarta-edicion-castellano.jpg",
                "Keyflower es un juego para dos a seis jugadores jugados en cuatro rondas. Cada ronda representa una estación: primavera, verano, otoño y finalmente invierno. Cada jugador comienza el juego con una ficha \"local\" y un equipo inicial de ocho trabajadores, cada uno de los cuales es de color rojo, amarillo o azul. Los jugadores usan trabajadores de colores coincidentes para ofertar por fichas para agregar a sus aldeas. Los trabajadores coincidentes pueden utilizarse alternativamente para generar recursos, habilidades y trabajadores adicionales, no solo de las fichas propias del jugador, sino también de las fichas en las aldeas de los otros jugadores y de las nuevas fichas que se subastan.\n" +
                        "\n" +
                        "En primavera, verano y otoño, más trabajadores llegarán a bordo de los botes Keyflower y su hermana, y algunos de estos trabajadores poseen habilidades en el trabajo de los recursos clave de hierro, piedra y madera. En cada una de estas temporadas, las fichas de la aldea se exponen al azar para la subasta. En el invierno no llegan nuevos trabajadores y los jugadores seleccionan las fichas de la aldea para la subasta de las que recibieron al comienzo del juego. Cada mosaico de la aldea de invierno ofrece VP para ciertas combinaciones de recursos, habilidades y trabajadores. El jugador cuya aldea y trabajadores generan la mayor cantidad de VP gana el juego.",
                otros ,
                2 ,
                6 ,
                euroGame ,
                120,
                "40XLRO3HZCk"
            )
            val caylus = JuegosDeMesa(
                "Caylus",
                "https://www.board-game.co.uk/wp-content/uploads/2017/10/Caylus-1.jpg" ,
                "Érase una vez ...\n" +
                        "1289. Para fortalecer las fronteras del Reino de Francia, el rey Felipe el justo decidió construir un nuevo castillo. Por el momento, Caylus no es más que un pueblo humilde, pero pronto, los trabajadores y artesanos se congregarán en la carreta, atraídos por las grandes perspectivas. Alrededor del sitio de construcción, una ciudad se está levantando lentamente.\n" +
                        "\n" +
                        "Los jugadores encarnan maestros constructores. Al construir el castillo del Rey y desarrollar la ciudad a su alrededor, ganan puntos de prestigio y obtienen el favor del Rey. Cuando se termina el castillo, el jugador que ha ganado más prestigio gana el juego. La expansión Caylus Expansion: The Jeweler se incluyó en la 2da Edición.\n" +
                        "\n" +
                        "Cada turno, los jugadores pagan para colocar a sus trabajadores en varios edificios de la aldea. Estos edificios permiten a los jugadores reunir recursos o dinero, o construir o mejorar edificios con esos recursos. Los jugadores también pueden usar sus recursos para ayudar a construir el castillo en sí, ganando puntos y favores del rey, que proporcionan bonificaciones más grandes. Construir un edificio proporciona algunos puntos inmediatos y potencialmente ingresos a lo largo del juego, ya que los jugadores reciben bonificaciones cuando otros usan sus edificios. Los edificios elegidos por los jugadores tienen un gran impacto en el curso del juego, ya que determinan las acciones que estarán disponibles para todos los jugadores.\n" +
                        "\n" +
                        "A medida que se construyen nuevos edificios, se extienden a lo largo de una carretera que se aleja del castillo, y no todos los edificios se pueden usar en cada vuelta. Los jugadores tienen cierto control sobre qué edificios están activos pagando para influir en el movimiento del marcador Provost. La posición final del marcador es el edificio más nuevo que se puede usar ese turno. El marcador Provost también ayuda a determinar el movimiento del marcador Bailiff, que determina el final del juego. En general, si los jugadores están construyendo muchos edificios y el Provost es generoso al permitir que se usen, el juego termina más rápidamente.",
                edge ,
                2,
                5 ,
                euroGame ,
                150,
                "nvgwljeJtnA"
            )
            val risingSun = JuegosDeMesa(
                "Rising sun" ,
                "https://www.planetongames.com/20650-large_default/rising-sun.jpg",
                "Rising Sun es un juego de mesa para 3 a 5 jugadores ambientado en el legendario Japón feudal. A medida que los Kami descienden de los cielos para remodelar la tierra a su imagen, cada jugador debe liderar a su clan hacia la victoria. Usa la política para promover tu causa, negocia para buscar las alianzas más rentables, adora a los Kami para ganar su favor, recluta monstruos fuera de la leyenda para reforzar tus fuerzas y usa tus recursos sabiamente para salir victorioso en la batalla. Creado por el aclamado diseñador Eric M. Lang, Rising Sun reúne a las mismas fuerzas creativas responsables del gran éxito Blood Rage , con impresionantes obras de arte de Adrian Smith e intrincadas miniaturas esculpidas bajo la dirección de Mike McVey.",
                edge ,
                3,
                5,
                estrategia ,
                120,
                "ARq5NeAvHRw"
            )
            val eldritchHorror = JuegosDeMesa(
                "Eldritch Horror ",
                "https://images-na.ssl-images-amazon.com/images/I/71URG2FQC4L._AC_SL1024_.jpg",
                "Eldritch Horror es un juego cooperativo de terror y aventura en el que de uno a ocho jugadores toman el papel de investigadores trotamundos que trabajan para resolver misterios, recopilar pistas y proteger el mundo de un Antiguo, es decir, un anciano que intenta destruir nuestro mundo. Cada Anciano viene con sus propios mazos únicos de cartas de Misterio e Investigación, que te llevan a lo más profundo de la historia que rodea a cada criatura repugnante. Descubre el verdadero nombre de Azathoth o lucha contra Cthulhu en alta mar.\n" +
                        "\n" +
                        "Si bien las tareas en estas tarjetas de Misterio (junto con las ubicaciones de puertas de otro mundo, monstruos amenazantes y pistas útiles) a menudo informarán tanto sus planes de viaje como los peligros que enfrenta, puede encontrar aventuras en cualquier parte del mundo ... incluso donde menos lo espero. Es durante la Fase de Encuentro de cada turno que los jugadores resuelven el combate o, alternativamente, construyen las historias personales de sus investigadores leyendo una narrativa de encuentro de uno de varios tipos de cartas de Encuentro. Puede enfrentarse cara a cara con un monstruo en Estambul o encontrarse en una situación difícil con el sindicato del crimen en una ciudad importante. Tal vez te embarques en una expedición a las Pirámides o busques una pista que descubras en el desierto sin nombre. Incluso puede encontrar su camino a través de una puerta y explorar una dimensión más allá del tiempo y el espacio.\n" +
                        "\n" +
                        "Si falla un encuentro, el costo es elevado. Si eres afortunado, simplemente sufrirás un trauma físico o mental. Sin embargo, también puede verse obligado a tomar una tarjeta de condición, que representa una lesión o restricción específica obtenida durante su viaje, como una lesión en la pierna o amnesia. Podrías encontrarte por encima de tu cabeza para adquirir activos y recibir una condición de Deuda, ¡o tal vez deberás un favor a algo mucho más insidioso que un cobrador de deudas y entrar en un Pacto Oscuro! Cualquiera sea su condición, sería prudente encontrar una resolución con prisa; Muchas condiciones tienen un \"efecto de ajuste de cuentas\" que, si se activa, garantiza un destino mucho más siniestro.",
                fantasyFlighGames ,
                1 ,
                8 ,
                cooperativo ,
                240,
                "QhtPnUUDG0E"
            )
            val patchwork = JuegosDeMesa(
                "Patchwork" ,
                "https://www.elgamusino.es/886-large_default/patchwork-.jpg",
                "En Patchwork , dos jugadores compiten para construir el edredón de patchwork más estético (y de mayor puntaje) en un tablero de juego personal de 9x9. Para comenzar a jugar, coloca todos los parches al azar en un círculo y coloca un marcador directamente en el sentido de las agujas del reloj del parche 2-1. Cada jugador toma cinco botones, la moneda / puntos en el juego, y se elige a alguien como jugador inicial.\n" +
                        "\n" +
                        "En un turno, un jugador compra uno de los tres parches en el sentido de las agujas del reloj o pasa. Para comprar un parche, paga el costo en los botones que se muestran en el parche, mueve el carrete a la ubicación de ese parche en el círculo, agrega el parche a tu tablero de juego, luego avanza tu ficha de tiempo en la pista de tiempo un número de espacios igual a El tiempo que se muestra en el parche. Eres libre de colocar el parche en cualquier lugar de tu tablero que no se superponga con otros parches, pero probablemente quieras unir las cosas lo más apretado posible. Si su ficha de tiempo está detrás o encima de la ficha de tiempo del otro jugador, entonces toma otro turno; de lo contrario el oponente ahora se va. En lugar de comprar un parche, puede elegir pasar; para hacer esto, mueves tu ficha de tiempo al espacio inmediatamente delante de la ficha de tiempo del oponente,",
                malditoGames ,
                2 ,
                2 ,
                abstractos ,
                30,
                "1_qjzmJhjCY"
            )
            val codigoSecreto = JuegosDeMesa(
                "Código secreto",
                "https://www.planetongames.com/14050/codigo-secreto.jpg",
                "Dos espías dominantes rivales conocen las identidades secretas de 25 agentes. Sus compañeros de equipo conocen a los agentes solo por sus códigos secretos.\n" +
                        "\n" +
                        "En código secreto , dos equipos compiten para ver quién puede contactar primero con todos sus agentes. Los Spymasters dan pistas de una palabra que pueden apuntar a varias palabras en el tablero. Sus compañeros de equipo intentan adivinar palabras del color correcto mientras evitan las que pertenecen al equipo contrario. Y todos quieren evitar al asesino.\n" +
                        "\n" +
                        "Nombres clave : Gane o pierda, es divertido descubrir las pistas.",
                devir ,
                2 ,
                8 ,
                abstractos,
                15,
                "Fd11RDhoMvk"
            )
            val islaDeLosGatos = JuegosDeMesa(
                "La isla de los gatos",
                "https://www.malditogames.com/wp-content/uploads/2019/10/FT_IslaGatos.jpg",
                "Ustedes son ciudadanos de Squalls End en una misión de rescate en La isla de los gatos y deben rescatar tantos gatos como sea posible antes de que llegue el malvado Lord Vesh. Cada gato está representado por un mosaico único y pertenece a una familia, debe encontrar una manera de que todos encajen en su bote mientras mantiene a las familias juntas.\n" +
                        "\n" +
                        "También necesitará administrar recursos a medida que:\n" +
                        "\n" +
                        "Explora la isla (dibujando cartas)\n" +
                        "Gatos de rescate\n" +
                        "Encuentra tesoros\n" +
                        "Hazte amigo de Oshax\n" +
                        "Estudiar lecciones antiguas\n" +
                        "Cada lección que recopiles te dará otra forma personal de sumar puntos, y hay 38 lecciones únicas disponibles.\n" +
                        "\n" +
                        "Complete las lecciones, llene su bote y mantenga a las familias de gatos juntas para sumar puntos, el ganador será el jugador con más puntos después de cinco rondas.",
                malditoGames,
                1,
                4,
                abstractos,
                90,
                "6OXNQ1nESsM"
            )
            val magicMaze = JuegosDeMesa(
                "Magic maze",
                "https://devir.co/wp-content/uploads/2019/12/magic-maze-1200x1200-web.jpg",
                "Después de ser despojados de todas sus posesiones, un mago, un guerrero, un elfo y un enano se ven obligados a robar el centro comercial local Magic Maze para obtener todo el equipo necesario para su próxima aventura. Acuerdan mapear el laberinto en su totalidad primero, luego encontrar la tienda favorita de cada individuo y luego ubicar la salida. Para evadir la vigilancia de los guardias que observaron sospechosamente su llegada, los cuatro realizarán sus atracos simultáneamente y luego se lanzarán a la salida. Ese es el plan de todos modos ... pero ¿pueden lograrlo?\n" +
                        "\n" +
                        "Magic Maze es un juego cooperativo en tiempo real. Cada jugador puede controlar a cualquier héroe para hacer que ese héroe realice una acción muy específica, a la que los otros jugadores no tienen acceso: muévete al norte, explora una nueva área, sube una escalera mecánica ... Todo esto requiere una cooperación rigurosa entre los jugadores para poder tener éxito en mover a los héroes con prudencia. Sin embargo, solo puedes comunicarte por períodos cortos durante el juego; el resto del tiempo, debes jugar sin dar señales visuales o de audio entre sí. Si todos los héroes logran salir del centro comercial en el tiempo limitado asignado para el juego, cada uno de los cuales ha robado un artículo muy específico, todos ganan juntos.\n" +
                        "\n" +
                        "Al comienzo del juego, solo tienes tres minutos para tomar medidas. Los espacios de reloj de arena que encuentre en el camino le dan más tiempo. Si el cronómetro de arena se agota por completo, todos los jugadores pierden el juego: ¡tu merodeo ha despertado sospechas y los guardias de seguridad del centro comercial te atrapan!",
                twoTomatoes,
                1 ,
                8 ,
                cooperativo ,
                15 ,
                "anFk1Y3Lkrk"
            )
            val dualPowers = JuegosDeMesa(
                "Duel Powers",
                "https://2tomatoesgames.com/wp-content/uploads/2020/04/caja-dual-powers.png",
                "En Marzo de 1917, el Zar Nicolás II fue forzado a abdicar el trono de Rusia. En su lugar se formó un Gobierno Provisional conservador, representando la autoridad oficial del estado. Opuesto a este gobierno se izó el Soviet de Petrogrado, un consejo electo de trabajadores organizados por activistas socialistas.\n" +
                        "En Dual Powers: Revolución 1917, cada jugador dirige las fuerzas de uno de los bandos en esta pugna a través de acciones políticas, maniobras sociales y conflicto militar. El jugador con mayor apoyo al final de la partida moldeará el futuro de Rusia y comenzará o evitará la inminente Guerra Civil.",
                twoTomatoes ,
                1,
                2,
                estrategia,
                45,
                "Uz3s8xGuquY"
            )
            val istambul = JuegosDeMesa(
                "Istambul",
                "https://http2.mlstatic.com/D_NQ_NP_618325-MLM25425794544_032017-O.jpg" ,
                "Mercaderes, ¡sed bienvenidos al bazar de Estambul!\n" +
                        "\n" +
                        "En este juego, ganador del Kennerspiel des Jahres en 2014, mercaderes y sirvientes se afanan por las estrechas callejuelas tratando de aventajar a la competencia. La clave es una buena organización… ¡hay tantas cosas por hacer! Comprar mercancías, venderlas, adular al sultán, pasar por la mezquita, recoger el correo… sin olvidar un buen juego de dados ante una relajante taza de té. ¡Ah! y ese sobrino siempre metido en problemas…",
                devir ,
                2,
                4,
                euroGame,
                60 ,
                "GosDKaXIr2Q"
            )
            val loveLetter = JuegosDeMesa(
                "Love letter",
                "https://juegosdemesayrol.com/wp-content/uploads/love-letter.jpg",
                "odos los jóvenes elegibles (y muchos de los no tan jóvenes) buscan cortejar a la princesa de Tempest. Desafortunadamente, ella se ha encerrado en el palacio, y debes confiar en que otros le lleven tus cartas románticas. ¿Llegará el tuyo primero?\n" +
                        "\n" +
                        "Love Letter es un juego de riesgo, deducción y suerte para 2–4 \u200B\u200Bjugadores. Su objetivo es poner su carta de amor en manos de la princesa Annette mientras desvía las cartas de los pretendientes competidores. Desde un mazo con solo dieciséis cartas, cada jugador comienza con solo una carta en la mano; Se retira una carta del juego. En un turno, robas una carta y juegas una carta, tratando de exponer a otros y sacarlos del juego. Las cartas poderosas conducen a ganancias tempranas, pero te convierten en un objetivo. Sin embargo, confíe en las cartas más débiles durante mucho tiempo, ¡y su carta puede arrojarse al fuego!",
                devir ,
                2 ,
                4 ,
                deckBuilder ,
                20 ,
                "NQcQDyoo_H0"
            )
            val gloomhaven = JuegosDeMesa(
                "Gloomhaven" ,
                "https://www.goblintrader.es/107355-thickbox_default/gloomhaven-2-edicion-spanish.jpg" ,
                "\"Gloomhaven\" es un juego de mesa de combate táctico, de inspiración euro, en un mundo de continuos motivos cambiantes. Los jugadores tomarán el papel de un aventurero errante con su propio conjunto especial de habilidades y sus propias razones para viajar a este oscuro rincón del mundo.\n" +
                        "\n" +
                        "Los jugadores deben trabajar juntos por pura necesidad para despejar amenazas y peligrosas ruinas olvidadas. En el proceso, mejorarán sus habilidades con la experiencia y el botín, descubrirán nuevos lugares para explorar y saquear, y expandirán una historia siempre ramificada alimentada por las decisiones que toman.\n" +
                        "\n" +
                        "Este es un juego de tipo \"legacy\" con un mundo persistente y cambiante que se juega idealmente durante varias sesiones de juego. Después de cada escenario, los jugadores tomarán decisiones sobre qué hacer, lo que determinará cómo continúa la historia, algo así como un libro de tipo \"elige tu propia aventura\".\n" +
                        "\n" +
                        "La partida a través de un escenario  se deberá realizar de forma cooperativa, donde los jugadores lucharán contra monstruos usando un innovador sistema de cartas para determinar el orden de juego y lo que un jugador puede llegar a hacer en su turno.\n" +
                        "\n" +
                        "Esencialmente, cada turno un jugador jugará dos cartas de su mano. Cada carta tiene un número en la parte superior, y el número en la primera carta jugada determinará su orden de iniciativa. Cada carta también tiene una potencia superior e inferior, y cuando es el turno de un jugador en el orden de iniciativa, habrá que determinar si usar la potencia superior de una tarjeta y la potencia inferior de la otra, o viceversa.\n" +
                        "\n" +
                        "Los jugadores deben tener cuidado, sin embargo, porque con el tiempo perderán de forma definitiva las cartas de sus manos. Si tardan demasiado en despejar una mazmorra, pueden acabar exhaustos y forzados a retirarse." ,
                asmodee ,
                1,
                4,
                estrategia,
                120,
                "lNOiByrpalQ"
            )
            val villainous = JuegosDeMesa(
                "Villainous",
                "https://www.kissradio.ca/wp-content/uploads/sites/6/2018/07/qk0aypsewgpwa0ljix34.jpg",
                "En esta épica lucha de poderes malignos asumirás el papel de un Villano Disney y tendrás que tratar de alcanzar tu propio objetivo maquiavélico. Descubre las habilidades únicas de tu personaje y su estrategia ganadora, aprovechando al mismo tiempo los giros del destino para frustrar los planes de tus oponentes. ¿Quién triunfará sobre las fuerzas del bien y se hará con la victoria?",
                otros,
                2,
                6,
                estrategia,
                50,
                "vsit3udwaDw"
            )
            val golpeDeFe = JuegosDeMesa(
                "Golpe de fe",
                "https://juegosdelamesaredonda.com/10308-47294-thickbox_default/golpe-de-fe.jpg",
                "Los dioses son todopoderosos... ¡pero también se aburren! Compite con el resto, usa tus habilidades únicas y reúne el mayor número de creyentes de todo el archipiélago en el centro del mundo.\n" +
                        "\n" +
                        "\"Golpe de Fe\" es un juego de mesa, de control de áreas y de habilidad, con unas reglas fáciles de aprender y unas mecánicas muy divertidas. Además de poder empezar a jugar a los pocos minutos de abrir la caja, \"Golpe de Fe\" tiene una gran rejugabilidad. Distintos dioses, muchísimas leyes emocionantes y tú: el divino golpeador.",
                malditoGames,
                2,
                4,
                estrategia,
                40,
                "gpEqVMAjwuY"
            )
            val spaceBase = JuegosDeMesa(
                "Space Base",
                "https://www.buroprocitation.ca/img/product/J29600_1-B.jpg?fv=49B27DF85F39DDD19FC04A4046B72D66-60715",
                "Space Base un juego de cartas en donde los jugadores asumen el rol de un comandante de una pequeña flota de naves espaciales. El objetivo, será ir ganando la suficiente influencia que les permita promocionar en almirante al final de la partida.\n" +
                        "\n" +
                        "Para conseguir este objetivo, deberás de hacer tratados comerciales y mejorar los ingresos de tu base, establecer nuevas colonias y todo lo que esté en tu mano para mejorar la influencia.\n" +
                        "\n" +
                        "Space Base es un juego sencillo de aprender y rápido de jugar en donde cada jugador tendrá que ir gestionando su base espacial a la que irá añadiendo diferentes tipos de naves para aumentar sus posibilidades de victoria.\n" +
                        "\n" +
                        "\n",
                malditoGames,
                2,
                5,
                estrategia,
                60,
                "r9Q3etMHlKI"
            )




            addCategorias(euroGame)
            addCategorias(cooperativo)
            addCategorias(dungeonCrawler)
            addCategorias(partyGames)
            addCategorias(deckBuilder)
            addCategorias(ameriTrash)
            addCategorias(thematicGames)
            addCategorias(estrategia)
            addCategorias(abstractos)
            addEditorial(devir)
            addEditorial(asmodee)
            addEditorial(edge)
            addEditorial(otros)
            addEditorial(ludonova)
            addEditorial(malditoGames)
            addEditorial(fantasyFlighGames)
            addEditorial(twoTomatoes)

        }
    }

    fun addCategorias(categorias: Categorias) {
        for (juego in DataHolder.allGames) {
            if (juego.categories == categorias) {
                categorias.boardGames.add(juego)
            }
        }
    }

    fun addEditorial(categorias: Editorial) {
        for (juego in DataHolder.allGames) {
            if (juego.editorial == categorias) {
                categorias.boardGames.add(juego)
            }
        }
    }


}

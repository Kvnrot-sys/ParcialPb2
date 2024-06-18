package ar.edu.unlam.pb2.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.pb2.dominio.instrumentos.Bateria;
import ar.edu.unlam.pb2.dominio.instrumentos.CasaDeMusica;
import ar.edu.unlam.pb2.dominio.instrumentos.Concierto;
import ar.edu.unlam.pb2.dominio.instrumentos.Evento;
import ar.edu.unlam.pb2.dominio.instrumentos.GuitarraElectrica;
import ar.edu.unlam.pb2.dominio.instrumentos.Instrumento;

public class CasaDeMusicaTest {
	
	private static final String NOMBRE_CASA_MUSICAL = "Casa musical";
	private CasaDeMusica casaDeMusica;
	
	@Before
	public void init() {
		this.casaDeMusica = new CasaDeMusica(NOMBRE_CASA_MUSICAL);
	}

	@Test
	public void queSePuedaAgregarUnInstrumentoGuitarraElectricaALaCasaDeMusica() {
		// preparacion
		Instrumento guitarraElectrica = this.crearGuitarraElectrica(1001, 6, "Azul", "Fender", "Stratocaster", 1994,
				true, 10, 1000D);
		
		// ejecucion
		Boolean instrumentoAgregado = casaDeMusica.agregarInstrumento(guitarraElectrica);

		// verificacion
		assertTrue(instrumentoAgregado);

	}

	@Test
	public void queSePuedaAgregarUnInstrumentoBateriaALaCasaDeMusica() {
		Instrumento bateria = this.crearBateria(2001, 1, 4, "Dorada", "Jazz", "Un modelo", 2000, 20, 2000D);
		
		Boolean instrumentoAgregado = casaDeMusica.agregarInstrumento(bateria);
		
		assertTrue(instrumentoAgregado);
	}
	
	@Test 
	public void dadoQueExistenInstrumentosEnLaCasaDeMusicaAlBuscarGuitarrasElectricasObtengoLoPropio() {
		// preparacion
		Instrumento guitarraElectrica = this.crearGuitarraElectrica(1001, 6, "Azul", "Fender", "Stratocaster", 1994,
				true, 10, 1000D);
		Instrumento segundaGuitarraElectrica = this.crearGuitarraElectrica(1002, 6, "Azul", "Fender", "Stratocaster", 1994,
				true, 5, 1000D);
		Instrumento bateria = this.crearBateria(2001, 1, 4, "Dorada", "Jazz", "Un modelo", 2000, 20, 2000D);
		Instrumento segundaBateria = this.crearBateria(2002, 1, 4, "Dorada", "Jazz", "Un modelo", 2000, 20, 2000D);
		this.casaDeMusica.agregarInstrumento(guitarraElectrica);
		this.casaDeMusica.agregarInstrumento(segundaGuitarraElectrica);
		this.casaDeMusica.agregarInstrumento(bateria);
		this.casaDeMusica.agregarInstrumento(segundaBateria);
		
		// ejecucion
		List<Instrumento> instrumentosGuitarraElectrica = this.casaDeMusica.obtenerInstrumentosGuitarraElectrica(); 
		
		// verificacion
		int cantidadEsperadaInstrumentos = 2;
		assertEquals(cantidadEsperadaInstrumentos, instrumentosGuitarraElectrica.size());
	}
	
	@Test
	public void dadoQueExisteUnInstrumentoBateriaEnLaCasaDeMusicaPuedeEmitirSonido() {
		// preparacion
		Instrumento bateria = this.crearBateria(2002, 1, 4, "Dorada", "Jazz", "Un modelo", 2000, 20, 2000D);
		
		// ejecucion
		String sonidoObtenido = bateria.emitirSonido();
		
		// verificacion
		String sonidoEsperado = "Budum tassh";
		assertEquals(sonidoEsperado, sonidoObtenido);
	}
	
	@Test
	public void dadoQueExisteUnInstrumentoGuitarraElectricaEnLaCasaDeMusicaPuedeEmitirSonido() {
		// preparacion
		Instrumento guitarraElectrica = this.crearGuitarraElectrica(1001, 6, "Azul", "Fender", "Stratocaster", 1994,
				true, 10, 1000D);
		
		// ejecucion
		String sonidoObtenido = guitarraElectrica.emitirSonido();
		
		// verificacion
		String sonidoEsperado = "Sonido de guitarra";
		assertEquals(sonidoEsperado, sonidoObtenido);
	}


	@Test
	public void dadoQueExistenInstrumentosEnLaCasaDeMusicaAlBuscarUnInstrumentoPorCodigoExistenteObtengoElInstrumento() {
		Instrumento guitarraElectrica = this.crearGuitarraElectrica(1003, 6, "Azul", "Fender", "Stratocaster", 1994,
				true, 10, 1000D);
		Instrumento segundaGuitarraElectrica = this.crearGuitarraElectrica(1002, 6, "Azul", "Fender", "Stratocaster", 1994,
				true, 5, 1000D);
		Instrumento bateria = this.crearBateria(2002, 1, 4, "Dorada", "Jazz", "Un modelo", 2000, 20, 2000D);
		Instrumento segundaBateria = this.crearBateria(2001, 1, 4, "Dorada", "Jazz", "Un modelo", 2000, 20, 2000D);
		this.casaDeMusica.agregarInstrumento(guitarraElectrica);
		this.casaDeMusica.agregarInstrumento(segundaGuitarraElectrica);
		this.casaDeMusica.agregarInstrumento(bateria);
		this.casaDeMusica.agregarInstrumento(segundaBateria);
		
		// ejecucion
		int codigoBuscado = 2001;
		Instrumento instrumento = this.casaDeMusica.buscarInstrumentoPorCodigo(codigoBuscado);
		
		// verificacion
		assertNotNull(instrumento);
		assertEquals(codigoBuscado, (int)instrumento.getCodigo());
	}
	
	@Test
	public void dadoQueExistenInstrumentosEnLaCasaDeMusicaAlBuscarUnInstrumentoPorCodigoInexistenteObtengoNull() {
		Instrumento guitarraElectrica = this.crearGuitarraElectrica(1001, 6, "Azul", "Fender", "Stratocaster", 1994,
				true, 10, 1000D);
		Instrumento segundaGuitarraElectrica = this.crearGuitarraElectrica(1002, 6, "Azul", "Fender", "Stratocaster", 1994,
				true, 5, 1000D);
		Instrumento bateria = this.crearBateria(2001, 1, 4, "Dorada", "Jazz", "Un modelo", 2000, 20, 2000D);
		Instrumento segundaBateria = this.crearBateria(2002, 1, 4, "Dorada", "Jazz", "Un modelo", 2000, 20, 2000D);
		this.casaDeMusica.agregarInstrumento(guitarraElectrica);
		this.casaDeMusica.agregarInstrumento(segundaGuitarraElectrica);
		this.casaDeMusica.agregarInstrumento(bateria);
		this.casaDeMusica.agregarInstrumento(segundaBateria);
		
		// ejecucion
		int codigoBuscado = 3001;
		Instrumento instrumento = this.casaDeMusica.buscarInstrumentoPorCodigo(codigoBuscado);
		
		// verificacion
		assertNull(instrumento);
	}
	
	@Test
	public void dadoQueExisteUnInstrumentoGuitarraElectricaEnLaCasaDeMusicaAlObtrenerloPorCodigoSePuedeObtenerElPrecio() {
		Instrumento guitarraElectrica = this.crearGuitarraElectrica(1001, 6, "Azul", "Fender", "Stratocaster", 1994,
				true, 10, 1000D);
		
		this.casaDeMusica.agregarInstrumento(guitarraElectrica);
		
		Double precioObtenido = this.casaDeMusica.obtenerPrecioInstrumento(1001);
		
		Double precioEsperado = 1100D;
		assertEquals(precioEsperado, precioObtenido);
	}
	
	@Test
	public void dadoQueExisteUnInstrumentoBateriaEnLaCasaDeMusicaAlObtrenerloPorCodigoSePuedeObtenerElPrecio() {
		Instrumento bateria = this.crearBateria(2001, 2, 4, "Dorada", "Jazz", "Un modelo", 2000, 20, 2000D);
		this.casaDeMusica.agregarInstrumento(bateria);
		
		Double precioObtenido = this.casaDeMusica.obtenerPrecioInstrumento(2001);
		
		Double precioEsperado = 3800D;
		assertEquals(precioEsperado, precioObtenido);
	}
	
	@Test
	public void dadoQueExistenInstumentosEnLaCasaDeMusicaAlObtenerlosEstanOrdenados() {
		Instrumento guitarraElectrica = this.crearGuitarraElectrica(1003, 6, "Azul", "Fender", "Stratocaster", 1994,
				true, 10, 1000D);
		Instrumento segundaGuitarraElectrica = this.crearGuitarraElectrica(1002, 6, "Azul", "Fender", "Stratocaster", 1994,
				true, 5, 1000D);
		Instrumento bateria = this.crearBateria(2002, 1, 4, "Dorada", "Jazz", "Un modelo", 2000, 20, 2000D);
		Instrumento segundaBateria = this.crearBateria(2001, 1, 4, "Dorada", "Jazz", "Un modelo", 2000, 20, 2000D);
		this.casaDeMusica.agregarInstrumento(guitarraElectrica);
		this.casaDeMusica.agregarInstrumento(segundaGuitarraElectrica);
		this.casaDeMusica.agregarInstrumento(bateria);
		this.casaDeMusica.agregarInstrumento(segundaBateria);
		
		List<Instrumento> instrumentosObtenidos = this.casaDeMusica.obtenerInstrumentos();
		
		assertEquals(1002, (int)instrumentosObtenidos.get(0).getCodigo());
		assertEquals(1003, (int)instrumentosObtenidos.get(1).getCodigo());
		assertEquals(2001, (int)instrumentosObtenidos.get(2).getCodigo());
		assertEquals(2002, (int)instrumentosObtenidos.get(3).getCodigo());
	}
	
	@Test
	public void dadoQueExisteUnaCasaDeMusicaSePuedeAgregarUnEvento() {
		// Given-When-Then
		String nombre = "Lolla";
		LocalDate dia = LocalDate.of(2024, 05, 15);
		LocalTime horaDeInicio = LocalTime.of(21, 0);
		LocalTime horaDeFin = LocalTime.of(23, 0);
		Evento evento = new Evento(nombre, dia, horaDeInicio, horaDeFin);
		
		Boolean agregado = this.casaDeMusica.agregarEvento(evento);
		
		assertTrue(agregado);
	}
	
	@Test
	public void dadoQueExisteUnaCasaDeMusicaConUnEventoSePuedeAgregarVariosConciertos() {
		String nombre = "Lolla";
		LocalDate dia = LocalDate.of(2024, 05, 15);
		LocalTime horaDeInicio = LocalTime.of(21, 0);
		LocalTime horaDeFin = LocalTime.of(23, 0);
		Evento evento = new Evento(nombre, dia, horaDeInicio, horaDeFin);
		this.casaDeMusica.agregarEvento(evento);
		
		String nombreConcierto = "RHCP";
		Integer id = 1;
		Concierto concierto = new Concierto(id, nombreConcierto);
		Concierto conciertoDos = new Concierto(2, "Artic");
		Concierto conciertoTres = new Concierto(3, "Limp");
		
		Boolean agregadoConciertoUno = this.casaDeMusica.agregarConciertoAEvento(evento, concierto);
		Boolean agregadoConciertoDos =this.casaDeMusica.agregarConciertoAEvento(evento, conciertoDos);
		Boolean agregadoConciertoTres =this.casaDeMusica.agregarConciertoAEvento(evento, conciertoTres);
		
		assertTrue(agregadoConciertoUno);
		assertTrue(agregadoConciertoDos);
		assertTrue(agregadoConciertoTres);
		
	}
	
	@Test
	public void dadoQueExisteUnaCasaDeMusicaConUnEventoYUnConciertoSePuedeAsignarUnInstrumentoAUnConcierto() {
		String nombre = "Lolla";
		LocalDate dia = LocalDate.of(2024, 05, 15);
		LocalTime horaDeInicio = LocalTime.of(21, 0);
		LocalTime horaDeFin = LocalTime.of(23, 0);
		Evento evento = new Evento(nombre, dia, horaDeInicio, horaDeFin);
		this.casaDeMusica.agregarEvento(evento);
		
		String nombreConcierto = "RHCP";
		Integer id = 1;
		Concierto concierto = new Concierto(id, nombreConcierto);
		Concierto conciertoDos = new Concierto(2, "Artic");
		Concierto conciertoTres = new Concierto(3, "Limp");
		
		this.casaDeMusica.agregarConciertoAEvento(evento, concierto);
		this.casaDeMusica.agregarConciertoAEvento(evento, conciertoDos);
		this.casaDeMusica.agregarConciertoAEvento(evento, conciertoTres);
		
		Instrumento guitarraElectrica = this.crearGuitarraElectrica(1001, 6, "Azul", "Fender", "Stratocaster", 1994,
				true, 10, 1000D);
		Instrumento guitarraCriolla = this.crearGuitarraElectrica(1002, 6, "Azul", "Fender", "Stratocaster", 1994,
				true, 10, 1000D);
		
		
		Boolean electricaAgregada = this.casaDeMusica.asignarInstrumentoAConciertoDeEvento(evento, concierto, guitarraElectrica);
//		Boolean criollaAgregada = this.casaDeMusica.agregarInstrumentoAConciertoDeEvento(evento, concierto, guitarraCriolla);
		
		assertTrue(electricaAgregada);
//		assertTrue(criollaAgregada);
	}
	
	@Test
	public void dadoQueExisteUnaCasaDeMusicaConUnEventoYUnConciertoSePuedeAgregarVariosInstrumentosAUnConcierto() {
		String nombre = "Lolla";
		LocalDate dia = LocalDate.of(2024, 05, 15);
		LocalTime horaDeInicio = LocalTime.of(21, 0);
		LocalTime horaDeFin = LocalTime.of(23, 0);
		Evento evento = new Evento(nombre, dia, horaDeInicio, horaDeFin);
		this.casaDeMusica.agregarEvento(evento);
		
		String nombreConcierto = "RHCP";
		Integer id = 1;
		Concierto concierto = new Concierto(id, nombreConcierto);
		
		Instrumento guitarraElectrica = this.crearGuitarraElectrica(1001, 6, "Azul", "Fender", "Stratocaster", 1994,
				true, 10, 1000D);
		Instrumento guitarraCriolla = this.crearGuitarraElectrica(1002, 6, "Azul", "Fender", "Stratocaster", 1994,
				true, 10, 1000D);
		
		
		Boolean electricaAgregada = this.casaDeMusica.agregarConciertoInstrumentoAEvento(evento, concierto, guitarraElectrica);
		Boolean criollaAgregada = this.casaDeMusica.agregarConciertoInstrumentoAEvento(evento, concierto, guitarraCriolla);
		
		assertTrue(electricaAgregada);
		assertTrue(criollaAgregada);
	}
	
	@Test
	public void dadoQueExisteUnaCasaDeMusicaConUnEventoYUnConciertoSePuedenObtenerLosInstrumentosDeUnConcierto() {
		String nombre = "Lolla";
		LocalDate dia = LocalDate.of(2024, 05, 15);
		LocalTime horaDeInicio = LocalTime.of(21, 0);
		LocalTime horaDeFin = LocalTime.of(23, 0);
		Evento evento = new Evento(nombre, dia, horaDeInicio, horaDeFin);
		this.casaDeMusica.agregarEvento(evento);
		
		String nombreConcierto = "RHCP";
		Integer id = 1;
		Concierto concierto = new Concierto(id, nombreConcierto);
		Instrumento guitarraElectrica = this.crearGuitarraElectrica(1001, 6, "Azul", "Fender", "Stratocaster", 1994,
				true, 10, 1000D);
		Instrumento guitarraCriolla = this.crearGuitarraElectrica(1002, 6, "Azul", "Fender", "Stratocaster", 1994,
				true, 10, 1000D);
		this.casaDeMusica.agregarConciertoInstrumentoAEvento(evento, concierto, guitarraElectrica);
		this.casaDeMusica.agregarConciertoInstrumentoAEvento(evento, concierto, guitarraCriolla);
		
		Concierto conciertoDos = new Concierto(2, "Linkin");
		Instrumento bateria = this.crearBateria(2002, 1, 4, "Dorada", "Jazz", "Un modelo", 2000, 20, 2000D);
		this.casaDeMusica.agregarConciertoInstrumentoAEvento(evento, conciertoDos, bateria);
		
		List<Instrumento> instrumentos = this.casaDeMusica.obtenerLosInstrumentosDeUnConciertoParaUnEvento(evento, concierto);
		
		assertEquals(2, instrumentos.size());
	}
	
	@Test
	public void dadoQueExisteUnaCasaDeMusicaConUnEventoYVariosConciertosConInstrumentosSePuedenObtenerLosConciertosDondeSeUtilizoUnInstrumento() {}
	
	@Test
	public void dadoQueExisteUnaCasaDeMusicaConUnEventoYVariosConciertosConInstrumentosNoSePuedeAgregarUnConciertoInstrumentoExistente() {
		String nombre = "Lolla";
		LocalDate dia = LocalDate.of(2024, 05, 15);
		LocalTime horaDeInicio = LocalTime.of(21, 0);
		LocalTime horaDeFin = LocalTime.of(23, 0);
		Evento evento = new Evento(nombre, dia, horaDeInicio, horaDeFin);
		this.casaDeMusica.agregarEvento(evento);
		
		String nombreConcierto = "RHCP";
		Integer id = 1;
		Concierto concierto = new Concierto(id, nombreConcierto);
		Instrumento guitarraElectrica = this.crearGuitarraElectrica(1001, 6, "Azul", "Fender", "Stratocaster", 1994,
				true, 10, 1000D);
		Instrumento guitarraCriolla = this.crearGuitarraElectrica(1002, 6, "Azul", "Fender", "Stratocaster", 1994,
				true, 10, 1000D);
		this.casaDeMusica.agregarConciertoInstrumentoAEvento(evento, concierto, guitarraElectrica);
		this.casaDeMusica.agregarConciertoInstrumentoAEvento(evento, concierto, guitarraCriolla);
		
		this.casaDeMusica.agregarConciertoInstrumentoAEvento(evento, concierto, guitarraCriolla);
		 

		List<Instrumento> instrumentos = this.casaDeMusica.obtenerLosInstrumentosDeUnConciertoParaUnEvento(evento, concierto);
		
		assertEquals(2, instrumentos.size());
	}
	
	@Test
	public void dadoQueExisteUnaCasaDeMusicaConMuchosEventosYVariosConciertosEnCadaEventoSePuedenObtenerLosEventosDondeSeDioUnConcierto() {}
	
	@Test
	public void dadoQueExisteUnaCasaDeMusicaConUnEventoYVariosConciertosConInstrumentosSePuedenObtenerLosConciertosDondeSeUtilizoUnInstrumentosGuitarra() {}
	
	
	
	@Test
		public void dadoQueExistenInstumentosEnLaCasaDeMusicaAlObtenerOrdenadosPorOrdenNatural() {
		Instrumento guitarraElectrica = this.crearGuitarraElectrica(1003, 6, "Azul", "Fender", "Stratocaster", 1994,
				true, 10, 1000D);
		Instrumento segundaGuitarraElectrica = this.crearGuitarraElectrica(1002, 6, "Azul", "Fender", "Stratocaster", 1994,
				true, 5, 1000D);
		Instrumento bateria = this.crearBateria(2002, 1, 4, "Dorada", "Jazz", "Un modelo", 2000, 20, 2000D);
		Instrumento segundaBateria = this.crearBateria(2001, 1, 4, "Dorada", "Jazz", "Un modelo", 2000, 20, 2000D);
		this.casaDeMusica.agregarInstrumento(guitarraElectrica);
		this.casaDeMusica.agregarInstrumento(segundaGuitarraElectrica);
		this.casaDeMusica.agregarInstrumento(bateria);
		this.casaDeMusica.agregarInstrumento(segundaBateria);
		
		TreeSet<Instrumento> instrumentosObtenidos = this.casaDeMusica.obtenerInstrumentosOrdenadosPorNatural();
		
		assertEquals(4, instrumentosObtenidos.size());
	
		int i= 0;
		
		for (Instrumento instrumento : instrumentosObtenidos) {
		
			switch (i) {
			case 0:

				assertEquals(1002, (int)instrumento.getCodigo());

				break;


			case 1:

				assertEquals(1003, (int)instrumento.getCodigo());

				break;
			case 2:

				assertEquals(2001, (int)instrumento.getCodigo());

				break;
			case 3:

				assertEquals(2002, (int)instrumento.getCodigo());

				break;

			
			default:
				break;
			}
			
			i++;

			
		}
				
		assertEquals(1002, (int)instrumentosObtenidos.first().getCodigo());
		assertEquals(2002, (int)instrumentosObtenidos.last().getCodigo());
		
		
		
 	}
	

	@Test
	public void dadoQueExistenInstumentosEnLaCasaDeMusicaAlObtenerOrdenadosPorOrdenEspecifico() {
	Instrumento guitarraElectrica = this.crearGuitarraElectrica(1003, 6, "Azul", "Fender", "Stratocaster", 1994,
			true, 10, 1000D);
	Instrumento segundaGuitarraElectrica = this.crearGuitarraElectrica(1002, 6, "Azul", "Fender", "Stratocaster", 1994,
			true, 5, 1000D);
	Instrumento bateria = this.crearBateria(2002, 1, 4, "Dorada", "Jazz", "Un modelo", 2000, 20, 2000D);
	Instrumento segundaBateria = this.crearBateria(2001, 1, 4, "Dorada", "Jazz", "Un modelo", 2000, 20, 2000D);
	this.casaDeMusica.agregarInstrumento(guitarraElectrica);
	this.casaDeMusica.agregarInstrumento(segundaGuitarraElectrica);
	this.casaDeMusica.agregarInstrumento(bateria);
	this.casaDeMusica.agregarInstrumento(segundaBateria);
	
	TreeSet<Instrumento> instrumentosObtenidos = this.casaDeMusica.obtenerInstrumentosOrdenadosOrdenEspecifico(new OrdenDescenciente());
	
	assertEquals(4, instrumentosObtenidos.size());

	int i= 0;
	
	for (Instrumento instrumento : instrumentosObtenidos) {
	
		switch (i) {
		case 0:

			assertEquals(2002, (int)instrumento.getCodigo());

			break;


		case 1:

			assertEquals(2001, (int)instrumento.getCodigo());

			break;
		case 2:

			assertEquals(1003, (int)instrumento.getCodigo());

			break;
		case 3:

			assertEquals(1002, (int)instrumento.getCodigo());

			break;

		
		default:
			break;
		}
		
		i++;

		
	}
			
	assertEquals(2002, (int)instrumentosObtenidos.first().getCodigo());
	assertEquals(1002, (int)instrumentosObtenidos.last().getCodigo());
	
	
	
	}

	
	
	private Instrumento crearBateria(int codigo, int cantidadTambores, int cantidadPlatillos, String color,
			String marca, String modelo, int anioFabricacion, int stock, Double precioBase) {
		return new Bateria(codigo, cantidadTambores, cantidadPlatillos, color, marca, modelo, anioFabricacion, stock, precioBase);
	}

	private Instrumento crearGuitarraElectrica(Integer codigo, Integer cantidadDeCuerdas, String color, String marca,
			String modelo, Integer anioFabricacion, Boolean microfonosActivos, Integer stock, Double precioBase) {
		return new GuitarraElectrica(codigo, cantidadDeCuerdas, microfonosActivos, stock, color, marca, modelo,
				anioFabricacion, precioBase);

	}
	
	
	
}

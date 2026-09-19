# Mutant Battle
- Aclarando previamente que como se dijo en las instrucciones del caso#1, estaré utilizando gran parte de la estructura utilizada en el trabajo de mutantes realizado en semana 5.

## Especificación de objetos

### 1. Mutante

**Atributos**
- `nombre: String`
- `energiaActual: double`
- `capacidadDefensa: int`
- `velocidad: double`
- `posicionX: double`
- `posicionY: double`
- `poder: IPower`
- `equipo: Equipo`

**Métodos**
- `mover(): void`
- `recibirDanio(danio: double): void`
- `estaVivo(): boolean`
- `decidirAccion(): AccionCombate`
- `aumentarPoder(): void`

---------------------------------------

### 2. Poder

**Atributos**
- `capacidadDanio: int`

**Métodos**
- `usarPoder(): void`
- `obtenerCapacidadDanio(): int`
- `aumentarDanio(): void`

-----------------------------------

### 3. PoderTirarFuego

**Atributos**
- Ninguno adicional.

**Métodos**
- `usarPoder(): void`

---------------------------------------

### 4. PoderTirarFlechas

**Atributos**
- Ninguno adicional.

**Métodos**
- `usarPoder(): void`

---------------------------------------------

### 5. PoderTirarCablesElectrocutantes

**Atributos**
- Ninguno adicional.

**Métodos**
- `usarPoder(): void`

-----------------------------------------------

### 6. PoderTirarNieve

**Atributos**
- Ninguno adicional.

**Métodos**
- `usarPoder(): void`

--------------------------------------

### 7. PoderTirarBorbujas

**Atributos**
- Ninguno adicional.

**Métodos**
- `usarPoder(): void`

----------------------------------------

### 8. Equipo

**Atributos**
- `mutantes: List<Mutante>`
- `color: String`
- `simbolo: String`

**Métodos**
- `agregarMutante(mutante: Mutante): void`
- `obtenerVivos(): int`
- `obtenerMuertos(): int`
- `estaDerrotado(): boolean`

------------------------------------

### 9. CampoBatalla

**Atributos**
- `ancho: double`
- `alto: double`
- `equipoUno: Equipo`
- `equipoDos: Equipo`

**Métodos**
- `obtenerAncho(): double`
- `obtenerAlto(): double`
- `obtenerEquipoUno(): Equipo`
- `obtenerEquipoDos(): Equipo`
- `terminoBatalla(): boolean`
- `obtenerGanador(): Equipo`

----------------------------------

### 10. ControlBatalla

**Atributos**
- `campoBatalla: CampoBatalla`
- `administradorCombate: AdministradorCombate`
- `hilosMutantes: List<HiloMutante>`

**Métodos**
- `iniciarBatalla(tamanoEquipo: int): void`
- `crearEquipos(tamanoEquipo: int): void`
- `iniciarHilos(): void`
- `detenerBatalla(): void`
- `terminoBatalla(): boolean`

---

### 11. HiloMutante

**Atributos**
- `mutante: Mutante`
- `campoBatalla: CampoBatalla`
- `administradorCombate: AdministradorCombate`

**Métodos**
- `run(): void`

---------------------------------------

### 12. AdministradorCombate

**Atributos**
- `campoBatalla: CampoBatalla`
- `radioCombate: double`

**Métodos**
- `buscarEncuentros(mutante: Mutante): void`
- `ejecutarCombate(mutanteUno: Mutante, mutanteDos: Mutante): void`
- `calcularDistancia(mutanteUno: Mutante, mutanteDos: Mutante): double`
- `calcularDanio(atacante: Mutante, defensor: Mutante): double`

---------------------------------------------

### 13. VistaBatalla

**Atributos**
- `campoBatalla: CampoBatalla`

**Métodos**
- `dibujarCampo(): void`
- `dibujarMutantes(): void`
- `actualizar(): void`
- `mostrarGanador(equipo: Equipo): void`

---------------------------------------------

### 14. ControladorInterfaz

**Atributos**
- `controlBatalla: ControlBatalla`
- `vistaBatalla: VistaBatalla`

**Métodos**
- `iniciarNuevaBatalla(tamanoEquipo: int): void`
- `actualizarVista(): void`

-------------------------------------------

### 15. ConstantesJuego

**Atributos**
- Contendrá las constantes utilizadas por el juego.

**Métodos**
- Ninguno.

---------------------------------------------

## Interfaces

### IPower

**Métodos**
- `usarPoder(): void`
- `obtenerCapacidadDanio(): int`
- `aumentarDanio(): void`

### Observador

**Métodos**
- `actualizar(): void`

----------------------------------

## Enumeración

### AccionCombate

**Valores**
- `ATACAR`
- `DEFENDER`

----------------------------------

## Relaciones principales

- `Poder` implementa `IPower`.
- Los poderes específicos heredan de `Poder`.
- `Mutante` tiene un `IPower`.
- `Mutante` pertenece a un `Equipo`.
- `CampoBatalla` contiene dos `Equipo`.
- `HiloMutante` trabaja con un `Mutante`.
- `AdministradorCombate` coordina los enfrentamientos.
- `VistaBatalla` implementa `Observador`.

## Decisiones de diseño

- Cada mutante tendrá su propia velocidad de movimiento.
- Se utilizará un `HiloMutante` por cada mutante.
- `AdministradorCombate` coordinará los enfrentamientos y no tendrá un hilo propio.
- Cada pareja de mutantes tendrá una sola acción de combate por encuentro.
- Los poderes utilizarán herencia y polimorfismo.
- Los valores configurables estarán en `ConstantesJuego`.
- La interfaz utilizará MVC y Observer.


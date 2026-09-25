# Mutant Battle
- Aclarando previamente que como se dijo en las instrucciones del caso#1, estaré utilizando gran parte de la estructura utilizada en el trabajo de mutantes realizado en semana 5.

## Especificación de objetos

## Paquetes

### model

Contiene las clases relacionadas con los mutantes y sus poderes.
- `Mutante`
- `Poder`
- `PoderTirarFuego`
- `PoderTirarFlechas`
- `PoderTirarCablesElectrocutantes`
- `PoderTirarNieve`
- `PoderTirarBorbujas`
- `IPower`

### game

Contiene las clases encargadas de representar el juego y el campo de batalla.
- `Equipo`
- `CampoBatalla`

### control

Contiene las clases encargadas de controlar el movimiento, los hilos y los combates.
- `ControlBatalla`
- `HiloMutante`
- `AdministradorCombate`

### ui

Contiene las clases encargadas de la interfaz gráfica.
- `VistaBatalla`
- `ControladorInterfaz`
- `Observador`

### constants

Contiene las constantes utilizadas por el juego.
- `ConstantesJuego`

## Paquetes de prueba

Cada capa tendrá su propio programa `main` para realizar pruebas independientes:
- `model`: pruebas de mutantes y poderes.
- `game`: pruebas de equipos y campo de batalla.
- `control`: pruebas de movimiento, combate e hilos.
- `ui`: pruebas de la interfaz.

### 1. Mutante

**Atributos**
- `nombre: String`
- `energiaActual: double`
- `capacidadDefensa: int`
- `velocidad: double`
- direccionX : double
- direccionY : double
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

## Ahora adjunto el código del UML y también la imagen del mismo

@startuml

title Mutant Battle - Diagrama UML

' =========================
' INTERFACES
' =========================

interface IPower {
    +usarPoder(): void
    +obtenerCapacidadDanio(): int
    +aumentarDanio(): void
}

interface Observador {
    +actualizar(): void
}

' =========================
' ENUMERACION
' =========================

enum AccionCombate {
    ATACAR
    DEFENDER
}

' =========================
' PODERES
' =========================

abstract class Poder {
    -capacidadDanio: int
    +usarPoder(): void
    +obtenerCapacidadDanio(): int
    +aumentarDanio(): void
}

class PoderTirarFuego {
    +usarPoder(): void
}

class PoderTirarFlechas {
    +usarPoder(): void
}

class PoderTirarCablesElectrocutantes {
    +usarPoder(): void
}

class PoderTirarNieve {
    +usarPoder(): void
}

class PoderTirarBorbujas {
    +usarPoder(): void
}

' =========================
' MODELO
' =========================

class Mutante {
    -nombre: String
    -energiaActual: double
    -capacidadDefensa: int
    -velocidad: double
    -direccionX: double
    -direccionY: double
    -posicionX: double
    -posicionY: double
    -poder: IPower
    -equipo: Equipo

    +mover(): void
    +recibirDanio(danio: double): void
    +estaVivo(): boolean
    +decidirAccion(): AccionCombate
    +aumentarPoder(): void
}

' =========================
' GAME
' =========================

class Equipo {
    -mutantes: List<Mutante>
    -color: String
    -simbolo: String

    +agregarMutante(mutante: Mutante): void
    +obtenerVivos(): int
    +obtenerMuertos(): int
    +estaDerrotado(): boolean
}

class CampoBatalla {
    -ancho: double
    -alto: double
    -equipoUno: Equipo
    -equipoDos: Equipo

    +obtenerAncho(): double
    +obtenerAlto(): double
    +obtenerEquipoUno(): Equipo
    +obtenerEquipoDos(): Equipo
    +terminoBatalla(): boolean
    +obtenerGanador(): Equipo
}

' =========================
' CONTROL
' =========================

class ControlBatalla {
    -campoBatalla: CampoBatalla
    -administradorCombate: AdministradorCombate
    -hilosMutantes: List<HiloMutante>

    +iniciarBatalla(tamanoEquipo: int): void
    +crearEquipos(tamanoEquipo: int): void
    +iniciarHilos(): void
    +detenerBatalla(): void
    +terminoBatalla(): boolean
}

class HiloMutante {
    -mutante: Mutante
    -campoBatalla: CampoBatalla
    -administradorCombate: AdministradorCombate

    +run(): void
}

class AdministradorCombate {
    -campoBatalla: CampoBatalla
    -radioCombate: double

    +buscarEncuentros(mutante: Mutante): void
    +ejecutarCombate(mutanteUno: Mutante, mutanteDos: Mutante): void
    +calcularDistancia(mutanteUno: Mutante, mutanteDos: Mutante): double
    +calcularDanio(atacante: Mutante, defensor: Mutante): double
}

' =========================
' UI
' =========================

class VistaBatalla {
    -campoBatalla: CampoBatalla

    +dibujarCampo(): void
    +dibujarMutantes(): void
    +actualizar(): void
    +mostrarGanador(equipo: Equipo): void
}

class ControladorInterfaz {
    -controlBatalla: ControlBatalla
    -vistaBatalla: VistaBatalla

    +iniciarNuevaBatalla(tamanoEquipo: int): void
    +actualizarVista(): void
}

' =========================
' CONSTANTES
' =========================

class ConstantesJuego

' =========================
' RELACIONES
' =========================

IPower <|.. Poder

Poder <|-- PoderTirarFuego
Poder <|-- PoderTirarFlechas
Poder <|-- PoderTirarCablesElectrocutantes
Poder <|-- PoderTirarNieve
Poder <|-- PoderTirarBorbujas

Mutante --> IPower
Mutante --> Equipo
Mutante --> AccionCombate

CampoBatalla *-- Equipo

ControlBatalla --> CampoBatalla
ControlBatalla --> AdministradorCombate
ControlBatalla --> HiloMutante

HiloMutante --> Mutante
HiloMutante --> CampoBatalla
HiloMutante --> AdministradorCombate

AdministradorCombate --> CampoBatalla

VistaBatalla ..|> Observador
VistaBatalla --> CampoBatalla

ControladorInterfaz --> ControlBatalla
ControladorInterfaz --> VistaBatalla

@enduml

<img width="837" height="821" alt="image" src="https://github.com/user-attachments/assets/87026d37-1e9a-4f09-89b3-084322700249" />

# 📦 Inventario Service

Servicio de gestión de inventario desarrollado en **Spring Boot** con arquitectura hexagonal. Permite la administración completa de productos, categorías y marcas para sistemas de e-commerce.

## 🚀 Características

- ✅ **Gestión de Productos**: CRUD completo de productos
- ✅ **Gestión de Categorías**: Organización por categorías
- ✅ **Gestión de Marcas**: Administración de marcas
- ✅ **Arquitectura Hexagonal**: Separación clara de responsabilidades
- ✅ **API REST**: Endpoints bien documentados
- ✅ **Validaciones**: Validación de datos de entrada
- ✅ **Manejo de Excepciones**: Control centralizado de errores

## 🛠️ Tecnologías

- **Java 17+**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **Spring Web**
- **Gradle**
- **H2/MySQL** (Base de datos)
- **Lombok**
- **MapStruct**

## 📋 Requisitos

- Java 17 o superior
- Gradle 8.x
- IDE (IntelliJ IDEA, Eclipse, VS Code)

## 🚀 Instalación y Ejecución

### 1. Clonar el repositorio
```bash
git clone https://github.com/camig-cx/inventario-service.git
cd inventario-service
```

### 2. Ejecutar con Gradle
```bash
./gradlew bootRun
```

### 3. Acceder a la aplicación
```
http://localhost:8080
```

## 📂 Estructura del Proyecto

```
src/main/java/com/arka/inventario/
├── application/           # Capa de aplicación
│   ├── dtos/             # DTOs de entrada y salida
│   ├── ports/            # Puertos de entrada
│   └── services/         # Servicios de aplicación
├── domain/               # Capa de dominio
│   ├── entities/         # Entidades del dominio
│   ├── exceptions/       # Excepciones del dominio
│   ├── repositories/     # Interfaces de repositorios
│   └── usecases/        # Casos de uso
└── infrastructure/       # Capa de infraestructura
    ├── adapters/        # Adaptadores
    └── config/          # Configuraciones
```

## 🔗 Endpoints Principales

### Productos
- `GET /api/productos` - Listar productos
- `POST /api/productos` - Crear producto
- `PUT /api/productos/{id}` - Actualizar producto
- `DELETE /api/productos/{id}` - Eliminar producto

### Categorías
- `GET /api/categorias` - Listar categorías
- `POST /api/categorias` - Crear categoría
- `PUT /api/categorias/{id}` - Actualizar categoría
- `DELETE /api/categorias/{id}` - Eliminar categoría

### Marcas
- `GET /api/marcas` - Listar marcas
- `POST /api/marcas` - Crear marca
- `PUT /api/marcas/{id}` - Actualizar marca
- `DELETE /api/marcas/{id}` - Eliminar marca

## 🧪 Pruebas

```bash
# Ejecutar todas las pruebas
./gradlew test

# Ejecutar con reporte de cobertura
./gradlew test jacocoTestReport
```

## 📝 Configuración

Editar `src/main/resources/application.properties`:

```properties
# Base de datos
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# JPA
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=create-drop
```

## 🤝 Contribución

1. Fork el proyecto
2. Crea una rama para tu feature (`git checkout -b feature/nueva-funcionalidad`)
3. Commit tus cambios (`git commit -m 'Agregar nueva funcionalidad'`)
4. Push a la rama (`git push origin feature/nueva-funcionalidad`)
5. Abre un Pull Request

## 📄 Licencia

Este proyecto sin lincencia.

## 👨‍💻 Autor

**Camilo** - [camig-cx](https://github.com/camig-cx)

---
*Desarrollado como parte del curso de Spring Boot - Arquitectura Hexagonal*

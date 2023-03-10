USE [master]
GO
/****** Object:  Database [dbPantryManager]    Script Date: 08/03/2023 16:30:54 ******/
CREATE DATABASE [dbPantryManager]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'dbPantryManager', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\dbPantryManager.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'dbPantryManager_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\dbPantryManager_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [dbPantryManager] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [dbPantryManager].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [dbPantryManager] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [dbPantryManager] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [dbPantryManager] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [dbPantryManager] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [dbPantryManager] SET ARITHABORT OFF 
GO
ALTER DATABASE [dbPantryManager] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [dbPantryManager] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [dbPantryManager] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [dbPantryManager] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [dbPantryManager] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [dbPantryManager] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [dbPantryManager] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [dbPantryManager] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [dbPantryManager] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [dbPantryManager] SET  DISABLE_BROKER 
GO
ALTER DATABASE [dbPantryManager] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [dbPantryManager] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [dbPantryManager] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [dbPantryManager] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [dbPantryManager] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [dbPantryManager] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [dbPantryManager] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [dbPantryManager] SET RECOVERY FULL 
GO
ALTER DATABASE [dbPantryManager] SET  MULTI_USER 
GO
ALTER DATABASE [dbPantryManager] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [dbPantryManager] SET DB_CHAINING OFF 
GO
ALTER DATABASE [dbPantryManager] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [dbPantryManager] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [dbPantryManager] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [dbPantryManager] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'dbPantryManager', N'ON'
GO
ALTER DATABASE [dbPantryManager] SET QUERY_STORE = OFF
GO
USE [dbPantryManager]
GO
/****** Object:  Table [dbo].[almacenan]    Script Date: 08/03/2023 16:30:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[almacenan](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Id_usuario] [int] NOT NULL,
	[Id_ingrediente] [int] NOT NULL,
	[Cantidad_almacenada] [varchar](500) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Autores]    Script Date: 08/03/2023 16:30:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Autores](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [varchar](50) NOT NULL,
	[Apellido] [varchar](50) NOT NULL,
	[Fecha_nacimiento] [date] NOT NULL,
	[Pais] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[consultan]    Script Date: 08/03/2023 16:30:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[consultan](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Id_receta] [int] NOT NULL,
	[Id_usuario] [int] NOT NULL,
	[Indice_match] [float] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Ingredientes]    Script Date: 08/03/2023 16:30:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Ingredientes](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [varchar](50) NOT NULL,
	[Tipo] [varchar](20) NOT NULL,
	[Calorias] [int] NOT NULL,
	[Imagen] [varchar](500) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Recetas]    Script Date: 08/03/2023 16:30:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Recetas](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [varchar](50) NOT NULL,
	[Pasos] [text] NOT NULL,
	[Tiempo_preparacion] [int] NOT NULL,
	[Dificultad] [varchar](20) NOT NULL,
	[Tipo_comida] [varchar](20) NOT NULL,
	[Autor] [varchar](50) NULL,
	[Enlace] [varchar](50) NULL,
	[Estado] [varchar](50) NOT NULL,
	[Votos_positivos] [int] NOT NULL,
	[Votos_negativos] [int] NOT NULL,
	[Votos_totales] [int] NOT NULL,
	[Es_personalizada] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tienen]    Script Date: 08/03/2023 16:30:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tienen](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Id_receta] [int] NOT NULL,
	[Id_ingrediente] [int] NOT NULL,
	[Cantidad] [varchar](500) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Usuarios]    Script Date: 08/03/2023 16:30:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Usuarios](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [varchar](50) NOT NULL,
	[Email] [varchar](50) NOT NULL,
	[Contraseña] [varchar](50) NOT NULL,
	[Rol] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[Email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[almacenan]  WITH CHECK ADD FOREIGN KEY([Id_ingrediente])
REFERENCES [dbo].[Ingredientes] ([Id])
GO
ALTER TABLE [dbo].[almacenan]  WITH CHECK ADD FOREIGN KEY([Id_usuario])
REFERENCES [dbo].[Usuarios] ([Id])
GO
ALTER TABLE [dbo].[consultan]  WITH CHECK ADD FOREIGN KEY([Id_receta])
REFERENCES [dbo].[Recetas] ([Id])
GO
ALTER TABLE [dbo].[consultan]  WITH CHECK ADD FOREIGN KEY([Id_usuario])
REFERENCES [dbo].[Usuarios] ([Id])
GO
ALTER TABLE [dbo].[tienen]  WITH CHECK ADD FOREIGN KEY([Id_ingrediente])
REFERENCES [dbo].[Ingredientes] ([Id])
GO
ALTER TABLE [dbo].[tienen]  WITH CHECK ADD FOREIGN KEY([Id_receta])
REFERENCES [dbo].[Recetas] ([Id])
GO
USE [master]
GO
ALTER DATABASE [dbPantryManager] SET  READ_WRITE 
GO

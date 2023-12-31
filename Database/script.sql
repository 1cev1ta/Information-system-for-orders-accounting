USE [master]
GO
/****** Object:  Database [diplomDB]    Script Date: 26.06.2023 18:06:30 ******/
CREATE DATABASE [diplomDB]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'diplomDB_Data', FILENAME = N'E:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\diplomDB.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'diplomDB_Log', FILENAME = N'E:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\diplomDB.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [diplomDB] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [diplomDB].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [diplomDB] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [diplomDB] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [diplomDB] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [diplomDB] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [diplomDB] SET ARITHABORT OFF 
GO
ALTER DATABASE [diplomDB] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [diplomDB] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [diplomDB] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [diplomDB] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [diplomDB] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [diplomDB] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [diplomDB] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [diplomDB] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [diplomDB] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [diplomDB] SET  DISABLE_BROKER 
GO
ALTER DATABASE [diplomDB] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [diplomDB] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [diplomDB] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [diplomDB] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [diplomDB] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [diplomDB] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [diplomDB] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [diplomDB] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [diplomDB] SET  MULTI_USER 
GO
ALTER DATABASE [diplomDB] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [diplomDB] SET DB_CHAINING OFF 
GO
ALTER DATABASE [diplomDB] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [diplomDB] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [diplomDB] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [diplomDB] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [diplomDB] SET QUERY_STORE = OFF
GO
USE [diplomDB]
GO
/****** Object:  Table [dbo].[Car]    Script Date: 26.06.2023 18:06:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Car](
	[ID_car] [int] IDENTITY(1,1) NOT NULL,
	[Date] [date] NULL,
	[Brand] [nvarchar](50) NULL,
	[Model] [nvarchar](50) NULL,
	[NK (FK)] [int] NULL,
 CONSTRAINT [PK_Car] PRIMARY KEY CLUSTERED 
(
	[ID_car] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Car_Details]    Script Date: 26.06.2023 18:06:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Car_Details](
	[ID_car (FK)] [int] NULL,
	[ID_details (FK)] [int] NULL,
	[Compatibility] [nchar](10) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Client]    Script Date: 26.06.2023 18:06:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Client](
	[NK] [int] IDENTITY(1,1) NOT NULL,
	[FIO] [nvarchar](50) NULL,
	[Gender] [char](1) NULL,
	[DateofBirth] [date] NULL,
 CONSTRAINT [PK_Client] PRIMARY KEY CLUSTERED 
(
	[NK] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Details]    Script Date: 26.06.2023 18:06:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Details](
	[ID_details] [int] IDENTITY(1,1) NOT NULL,
	[Name_details] [nvarchar](50) NULL,
	[Quantity] [int] NULL,
	[Price] [money] NULL,
	[Producer] [nvarchar](50) NULL,
 CONSTRAINT [PK_Details] PRIMARY KEY CLUSTERED 
(
	[ID_details] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Details_Order]    Script Date: 26.06.2023 18:06:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Details_Order](
	[ID_details (FK)] [int] NULL,
	[NZ (FK)] [int] NULL,
	[Quantity] [int] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Manager]    Script Date: 26.06.2023 18:06:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Manager](
	[ID_manager] [int] IDENTITY(1,1) NOT NULL,
	[FIO] [nvarchar](50) NULL,
	[Phone] [nvarchar](50) NULL,
	[Experience] [int] NULL,
	[Salary] [money] NULL,
 CONSTRAINT [PK_Manager] PRIMARY KEY CLUSTERED 
(
	[ID_manager] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Manager_Operations]    Script Date: 26.06.2023 18:06:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Manager_Operations](
	[idOrder] [int] IDENTITY(1,1) NOT NULL,
	[FIOClient] [nvarchar](50) NOT NULL,
	[FIOManager] [nvarchar](50) NOT NULL,
	[detailName] [nvarchar](50) NOT NULL,
	[quantityDetails] [int] NOT NULL,
	[carBrandName] [nvarchar](50) NOT NULL,
	[orderPrice] [money] NOT NULL,
 CONSTRAINT [PK_Manager_Operations] PRIMARY KEY CLUSTERED 
(
	[idOrder] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Order]    Script Date: 26.06.2023 18:06:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Order](
	[NZ] [int] IDENTITY(1,1) NOT NULL,
	[NK (FK)] [int] NULL,
	[ID_manager (FK)] [int] NULL,
	[ID_auto (FK)] [int] NULL,
	[Date] [date] NULL,
	[Sum] [money] NULL,
 CONSTRAINT [PK_Order] PRIMARY KEY CLUSTERED 
(
	[NZ] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Phone]    Script Date: 26.06.2023 18:06:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Phone](
	[NT] [int] IDENTITY(1,1) NOT NULL,
	[NK (FK)] [int] NULL,
	[Type] [nvarchar](50) NULL,
	[Phone] [nvarchar](50) NULL,
 CONSTRAINT [PK_Phone] PRIMARY KEY CLUSTERED 
(
	[NT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Car] ON 

INSERT [dbo].[Car] ([ID_car], [Date], [Brand], [Model], [NK (FK)]) VALUES (1, CAST(N'2001-08-20' AS Date), N'Nissan', N'Leaf', NULL)
INSERT [dbo].[Car] ([ID_car], [Date], [Brand], [Model], [NK (FK)]) VALUES (2, CAST(N'2005-12-05' AS Date), N'Mitsubishi', N'I MiEV', NULL)
INSERT [dbo].[Car] ([ID_car], [Date], [Brand], [Model], [NK (FK)]) VALUES (3, CAST(N'2008-05-17' AS Date), N'Toyota', N'RAV4EV', NULL)
INSERT [dbo].[Car] ([ID_car], [Date], [Brand], [Model], [NK (FK)]) VALUES (4, CAST(N'2010-04-28' AS Date), N'Honda', N'FitEV', NULL)
INSERT [dbo].[Car] ([ID_car], [Date], [Brand], [Model], [NK (FK)]) VALUES (5, CAST(N'2009-08-09' AS Date), N'Ford', N'Focus Electric', NULL)
INSERT [dbo].[Car] ([ID_car], [Date], [Brand], [Model], [NK (FK)]) VALUES (6, CAST(N'2012-10-16' AS Date), N'Tesla', N'Roadster', NULL)
INSERT [dbo].[Car] ([ID_car], [Date], [Brand], [Model], [NK (FK)]) VALUES (7, CAST(N'2019-12-08' AS Date), N'Tesla', N'Model S', NULL)
INSERT [dbo].[Car] ([ID_car], [Date], [Brand], [Model], [NK (FK)]) VALUES (8, CAST(N'2017-03-15' AS Date), N'Renault', N'Fluence Z.E. ', NULL)
INSERT [dbo].[Car] ([ID_car], [Date], [Brand], [Model], [NK (FK)]) VALUES (9, CAST(N'2015-06-09' AS Date), N'Volvo', N'C30 Electric', NULL)
INSERT [dbo].[Car] ([ID_car], [Date], [Brand], [Model], [NK (FK)]) VALUES (10, CAST(N'2009-09-18' AS Date), N'BMW', N'Active C', NULL)
SET IDENTITY_INSERT [dbo].[Car] OFF
GO
SET IDENTITY_INSERT [dbo].[Client] ON 

INSERT [dbo].[Client] ([NK], [FIO], [Gender], [DateofBirth]) VALUES (1, N'Spirin Boris Borisovich', N'M', CAST(N'1995-08-20' AS Date))
INSERT [dbo].[Client] ([NK], [FIO], [Gender], [DateofBirth]) VALUES (2, N'Inushkin Mark Sergeevich', N'M', CAST(N'2001-05-18' AS Date))
INSERT [dbo].[Client] ([NK], [FIO], [Gender], [DateofBirth]) VALUES (3, N'Klimochkin Egor Yakovlevich', N'M', CAST(N'1985-03-09' AS Date))
INSERT [dbo].[Client] ([NK], [FIO], [Gender], [DateofBirth]) VALUES (4, N'Alimov Aleksandr Aleksandrovich', N'M', CAST(N'1984-02-15' AS Date))
INSERT [dbo].[Client] ([NK], [FIO], [Gender], [DateofBirth]) VALUES (5, N'Savin Garik Hanovich', N'M', CAST(N'2002-06-20' AS Date))
INSERT [dbo].[Client] ([NK], [FIO], [Gender], [DateofBirth]) VALUES (6, N'Fanova Galina Viktorovna', N'F', CAST(N'1983-06-18' AS Date))
INSERT [dbo].[Client] ([NK], [FIO], [Gender], [DateofBirth]) VALUES (7, N'Utkina Maria Igorevna', N'F', CAST(N'1984-02-15' AS Date))
INSERT [dbo].[Client] ([NK], [FIO], [Gender], [DateofBirth]) VALUES (8, N'Orun Svetlana Klimovna', N'F', CAST(N'1978-04-23' AS Date))
INSERT [dbo].[Client] ([NK], [FIO], [Gender], [DateofBirth]) VALUES (9, N'Pakina Irina Borisovna', N'F', CAST(N'1994-09-03' AS Date))
INSERT [dbo].[Client] ([NK], [FIO], [Gender], [DateofBirth]) VALUES (10, N'Lunina Olivia Maksimovna', N'F', CAST(N'1986-11-18' AS Date))
INSERT [dbo].[Client] ([NK], [FIO], [Gender], [DateofBirth]) VALUES (11, N'Hanov Mihail Viktorovich', N'M', CAST(N'1986-09-17' AS Date))
INSERT [dbo].[Client] ([NK], [FIO], [Gender], [DateofBirth]) VALUES (12, N'Kuznezov Garik Ivanovich', N'M', CAST(N'1988-12-19' AS Date))
INSERT [dbo].[Client] ([NK], [FIO], [Gender], [DateofBirth]) VALUES (13, N'Letkin Kuzma Yurievich', N'M', CAST(N'1991-06-15' AS Date))
INSERT [dbo].[Client] ([NK], [FIO], [Gender], [DateofBirth]) VALUES (14, N'Kiriyakov Gleb Mihailovich', N'M', CAST(N'1995-07-13' AS Date))
SET IDENTITY_INSERT [dbo].[Client] OFF
GO
SET IDENTITY_INSERT [dbo].[Details] ON 

INSERT [dbo].[Details] ([ID_details], [Name_details], [Quantity], [Price], [Producer]) VALUES (1, N'Electric motor', 4, 400000.0000, N'UralElectro')
INSERT [dbo].[Details] ([ID_details], [Name_details], [Quantity], [Price], [Producer]) VALUES (2, N'Transmission', 8, 250000.0000, N'FPT Industrial')
INSERT [dbo].[Details] ([ID_details], [Name_details], [Quantity], [Price], [Producer]) VALUES (3, N'Onboard Сhargers', 25, 653000.0000, N'EV Expert')
INSERT [dbo].[Details] ([ID_details], [Name_details], [Quantity], [Price], [Producer]) VALUES (4, N'Inverter', 38, 856900.0000, N'SB LiMotive')
INSERT [dbo].[Details] ([ID_details], [Name_details], [Quantity], [Price], [Producer]) VALUES (5, N'Control System', 27, 945300.0000, N'Tesla')
INSERT [dbo].[Details] ([ID_details], [Name_details], [Quantity], [Price], [Producer]) VALUES (6, N'DC converter', 16, 567329.0000, N'LG Chem')
INSERT [dbo].[Details] ([ID_details], [Name_details], [Quantity], [Price], [Producer]) VALUES (7, N'Storage Battery', 19, 325680.0000, N'Samsung')
INSERT [dbo].[Details] ([ID_details], [Name_details], [Quantity], [Price], [Producer]) VALUES (8, N'Headlights', 7, 115000.0000, N'Bosch')
INSERT [dbo].[Details] ([ID_details], [Name_details], [Quantity], [Price], [Producer]) VALUES (9, N'Brake System', 10, 460720.0000, N'Brembo')
INSERT [dbo].[Details] ([ID_details], [Name_details], [Quantity], [Price], [Producer]) VALUES (10, N'Wheels', 2, 80000.0000, N'Continental')
INSERT [dbo].[Details] ([ID_details], [Name_details], [Quantity], [Price], [Producer]) VALUES (11, N'Chassis', 13, 216790.0000, N'DAF')
INSERT [dbo].[Details] ([ID_details], [Name_details], [Quantity], [Price], [Producer]) VALUES (12, N'Cooling System', 8, 360250.0000, N'Tesla')
INSERT [dbo].[Details] ([ID_details], [Name_details], [Quantity], [Price], [Producer]) VALUES (13, N'Сompressor', 16, 185640.0000, N'Tesla')
INSERT [dbo].[Details] ([ID_details], [Name_details], [Quantity], [Price], [Producer]) VALUES (14, N'Charger', 14, 250220.0000, N'Samsung')
INSERT [dbo].[Details] ([ID_details], [Name_details], [Quantity], [Price], [Producer]) VALUES (15, N'Сonverter', 26, 674320.0000, N'Samsung')
INSERT [dbo].[Details] ([ID_details], [Name_details], [Quantity], [Price], [Producer]) VALUES (17, N'Reducer', 18, 105400.0000, N'LG Chem')
INSERT [dbo].[Details] ([ID_details], [Name_details], [Quantity], [Price], [Producer]) VALUES (18, N'Windshield', 25, 403205.0000, N'DAF')
INSERT [dbo].[Details] ([ID_details], [Name_details], [Quantity], [Price], [Producer]) VALUES (19, N'Controller', 10, 360495.0000, N'SB LiMotive')
SET IDENTITY_INSERT [dbo].[Details] OFF
GO
INSERT [dbo].[Details_Order] ([ID_details (FK)], [NZ (FK)], [Quantity]) VALUES (3, 14, 23)
INSERT [dbo].[Details_Order] ([ID_details (FK)], [NZ (FK)], [Quantity]) VALUES (4, 2, 5)
INSERT [dbo].[Details_Order] ([ID_details (FK)], [NZ (FK)], [Quantity]) VALUES (5, 3, 34)
INSERT [dbo].[Details_Order] ([ID_details (FK)], [NZ (FK)], [Quantity]) VALUES (6, 4, 52)
INSERT [dbo].[Details_Order] ([ID_details (FK)], [NZ (FK)], [Quantity]) VALUES (8, 5, 16)
INSERT [dbo].[Details_Order] ([ID_details (FK)], [NZ (FK)], [Quantity]) VALUES (1, 6, 63)
INSERT [dbo].[Details_Order] ([ID_details (FK)], [NZ (FK)], [Quantity]) VALUES (13, 7, 29)
INSERT [dbo].[Details_Order] ([ID_details (FK)], [NZ (FK)], [Quantity]) VALUES (3, 8, 17)
INSERT [dbo].[Details_Order] ([ID_details (FK)], [NZ (FK)], [Quantity]) VALUES (12, 9, 32)
INSERT [dbo].[Details_Order] ([ID_details (FK)], [NZ (FK)], [Quantity]) VALUES (9, 10, 21)
INSERT [dbo].[Details_Order] ([ID_details (FK)], [NZ (FK)], [Quantity]) VALUES (10, 1, 15)
INSERT [dbo].[Details_Order] ([ID_details (FK)], [NZ (FK)], [Quantity]) VALUES (8, 2, 18)
INSERT [dbo].[Details_Order] ([ID_details (FK)], [NZ (FK)], [Quantity]) VALUES (4, 3, 19)
INSERT [dbo].[Details_Order] ([ID_details (FK)], [NZ (FK)], [Quantity]) VALUES (2, 4, 63)
INSERT [dbo].[Details_Order] ([ID_details (FK)], [NZ (FK)], [Quantity]) VALUES (7, 5, 27)
INSERT [dbo].[Details_Order] ([ID_details (FK)], [NZ (FK)], [Quantity]) VALUES (12, 6, 28)
INSERT [dbo].[Details_Order] ([ID_details (FK)], [NZ (FK)], [Quantity]) VALUES (2, 7, 15)
INSERT [dbo].[Details_Order] ([ID_details (FK)], [NZ (FK)], [Quantity]) VALUES (3, 8, 28)
INSERT [dbo].[Details_Order] ([ID_details (FK)], [NZ (FK)], [Quantity]) VALUES (7, 9, 17)
INSERT [dbo].[Details_Order] ([ID_details (FK)], [NZ (FK)], [Quantity]) VALUES (5, 10, 26)
INSERT [dbo].[Details_Order] ([ID_details (FK)], [NZ (FK)], [Quantity]) VALUES (3, 10, 29)
INSERT [dbo].[Details_Order] ([ID_details (FK)], [NZ (FK)], [Quantity]) VALUES (13, 2, 15)
INSERT [dbo].[Details_Order] ([ID_details (FK)], [NZ (FK)], [Quantity]) VALUES (2, 3, 93)
INSERT [dbo].[Details_Order] ([ID_details (FK)], [NZ (FK)], [Quantity]) VALUES (1, 4, 53)
INSERT [dbo].[Details_Order] ([ID_details (FK)], [NZ (FK)], [Quantity]) VALUES (2, 5, 14)
INSERT [dbo].[Details_Order] ([ID_details (FK)], [NZ (FK)], [Quantity]) VALUES (3, 13, 36)
INSERT [dbo].[Details_Order] ([ID_details (FK)], [NZ (FK)], [Quantity]) VALUES (3, 14, 45)
INSERT [dbo].[Details_Order] ([ID_details (FK)], [NZ (FK)], [Quantity]) VALUES (3, 15, 24)
INSERT [dbo].[Details_Order] ([ID_details (FK)], [NZ (FK)], [Quantity]) VALUES (3, 16, 35)
GO
SET IDENTITY_INSERT [dbo].[Manager] ON 

INSERT [dbo].[Manager] ([ID_manager], [FIO], [Phone], [Experience], [Salary]) VALUES (1, N'Orlov Victor Borisovich', N'+7-910-460-35-25', 2, 45000.0000)
INSERT [dbo].[Manager] ([ID_manager], [FIO], [Phone], [Experience], [Salary]) VALUES (2, N'Han Nikolay Grigorievich', N'+7-905-346-02-16', 5, 160000.0000)
INSERT [dbo].[Manager] ([ID_manager], [FIO], [Phone], [Experience], [Salary]) VALUES (3, N'Kuzmin Jamik Kirovich', N'+7-923-873-67-83', 3, 90000.0000)
INSERT [dbo].[Manager] ([ID_manager], [FIO], [Phone], [Experience], [Salary]) VALUES (4, N'Panov Gleb Pankovich', N'+7-962-365-80-21', 7, 255000.0000)
INSERT [dbo].[Manager] ([ID_manager], [FIO], [Phone], [Experience], [Salary]) VALUES (5, N'Lunov Jek Uronovich', N'+7-982-293-15-26', 4, 178000.0000)
INSERT [dbo].[Manager] ([ID_manager], [FIO], [Phone], [Experience], [Salary]) VALUES (6, N'Irin Anton Michailovich', N'+7-903-185-10-83', 9, 384000.0000)
INSERT [dbo].[Manager] ([ID_manager], [FIO], [Phone], [Experience], [Salary]) VALUES (7, N'Ranin Mark Titovich', N'+7-952-924-14-92', 8, 279302.0000)
INSERT [dbo].[Manager] ([ID_manager], [FIO], [Phone], [Experience], [Salary]) VALUES (8, N'Dunin Sergey Valerievich', N'+7-906-102-83-19', 1, 32000.0000)
INSERT [dbo].[Manager] ([ID_manager], [FIO], [Phone], [Experience], [Salary]) VALUES (9, N'Warkunin Foma Lampovich', N'+7-924-367-24-74', 10, 543000.0000)
INSERT [dbo].[Manager] ([ID_manager], [FIO], [Phone], [Experience], [Salary]) VALUES (10, N'Lama Yan Artemovich', N'+7-905-223-59-53', 3, 168000.0000)
INSERT [dbo].[Manager] ([ID_manager], [FIO], [Phone], [Experience], [Salary]) VALUES (12, N'Vasiliev Ivan Victorovich', N'+7-953-532-30-21', 6, 182930.0000)
INSERT [dbo].[Manager] ([ID_manager], [FIO], [Phone], [Experience], [Salary]) VALUES (13, N'Urinov Michail Kirovich', N'+7-973-743-23-63', 8, 250430.0000)
INSERT [dbo].[Manager] ([ID_manager], [FIO], [Phone], [Experience], [Salary]) VALUES (14, N'Nosova Ulia Fedorovna', N'+7-986-363-56-36', 5, 95305.0000)
INSERT [dbo].[Manager] ([ID_manager], [FIO], [Phone], [Experience], [Salary]) VALUES (15, N'Kinich Maria Haritonovna', N'+7-905-102-83-19', 2, 56900.0000)
INSERT [dbo].[Manager] ([ID_manager], [FIO], [Phone], [Experience], [Salary]) VALUES (16, N'Pronin Boris Valerievich', N'+7-965-236-86-03', 4, 138590.0000)
INSERT [dbo].[Manager] ([ID_manager], [FIO], [Phone], [Experience], [Salary]) VALUES (17, N'Aranian Kira Limovna', N'+7-984-743-25-83', 7, 357890.0000)
INSERT [dbo].[Manager] ([ID_manager], [FIO], [Phone], [Experience], [Salary]) VALUES (18, N'Titov Roman Genadievich', N'+7-973-264-75-23', 3, 176593.0000)
SET IDENTITY_INSERT [dbo].[Manager] OFF
GO
SET IDENTITY_INSERT [dbo].[Manager_Operations] ON 

INSERT [dbo].[Manager_Operations] ([idOrder], [FIOClient], [FIOManager], [detailName], [quantityDetails], [carBrandName], [orderPrice]) VALUES (1, N'Inushkin Mark Sergeevich', N'Orlov Victor Borisovich', N'Brake System', 5, N'Tesla Model S', 205103.0000)
INSERT [dbo].[Manager_Operations] ([idOrder], [FIOClient], [FIOManager], [detailName], [quantityDetails], [carBrandName], [orderPrice]) VALUES (3, N'Usovich Veronika Urievna', N'Han Nikolay Grigorievich', N'Inverter', 53, N'Renault Fluence Z.E.', 156320.0000)
INSERT [dbo].[Manager_Operations] ([idOrder], [FIOClient], [FIOManager], [detailName], [quantityDetails], [carBrandName], [orderPrice]) VALUES (4, N'Letkin Kuzma Yurievich', N'Kuzmin Jamik Kirovich', N'Headlights', 154, N'Ford Focus Electric', 1023.0000)
INSERT [dbo].[Manager_Operations] ([idOrder], [FIOClient], [FIOManager], [detailName], [quantityDetails], [carBrandName], [orderPrice]) VALUES (6, N'Fanova Galina Viktorovna', N'Panov Gleb Pankovich', N'Onboard Сhargers', 53, N'Toyota RAV4EV', 156320.0000)
INSERT [dbo].[Manager_Operations] ([idOrder], [FIOClient], [FIOManager], [detailName], [quantityDetails], [carBrandName], [orderPrice]) VALUES (9, N'Klimochkin Egor Yakovlevich', N'Lunov Jek Uronovich', N'Transmission', 2, N'BMW Active C', 143789.0000)
INSERT [dbo].[Manager_Operations] ([idOrder], [FIOClient], [FIOManager], [detailName], [quantityDetails], [carBrandName], [orderPrice]) VALUES (11, N'Orun Svetlana Klimovna', N'Dunin Sergey Valerievich', N'Cooling System', 6, N'Mitsubishi I MiEV', 275356.0000)
INSERT [dbo].[Manager_Operations] ([idOrder], [FIOClient], [FIOManager], [detailName], [quantityDetails], [carBrandName], [orderPrice]) VALUES (12, N'Alimov Aleksandr Aleksandrovich', N'Warkunin Foma Lampovich', N'Wheels', 8, N'Tesla Roadster', 532676.0000)
INSERT [dbo].[Manager_Operations] ([idOrder], [FIOClient], [FIOManager], [detailName], [quantityDetails], [carBrandName], [orderPrice]) VALUES (13, N'Kuznezov Garik Ivanovich', N'Ranin Mark Titovich', N'Chassis', 15, N'Honda FitEV', 345000.0000)
INSERT [dbo].[Manager_Operations] ([idOrder], [FIOClient], [FIOManager], [detailName], [quantityDetails], [carBrandName], [orderPrice]) VALUES (14, N'Irin Anton Michailovich', N'Kuzmin Jamik Kirovich', N'DC converter', 26, N'Volvo C30 Electric', 25367.0000)
INSERT [dbo].[Manager_Operations] ([idOrder], [FIOClient], [FIOManager], [detailName], [quantityDetails], [carBrandName], [orderPrice]) VALUES (15, N'Pakina Irina Borisovna', N'Lama Yan Artemovich', N'Electric motor', 5, N'Tesla Model S', 876530.0000)
INSERT [dbo].[Manager_Operations] ([idOrder], [FIOClient], [FIOManager], [detailName], [quantityDetails], [carBrandName], [orderPrice]) VALUES (18, N'Utkina Maria Igorevna', N'Lunov Jek Uronovich', N'Control System', 15, N'Nissan Leaf', 506392.0000)
INSERT [dbo].[Manager_Operations] ([idOrder], [FIOClient], [FIOManager], [detailName], [quantityDetails], [carBrandName], [orderPrice]) VALUES (19, N'Spirin Boris Borisovich', N'Irin Anton Michailovich', N'Brake System', 21, N'BMW Active C', 37546.0000)
INSERT [dbo].[Manager_Operations] ([idOrder], [FIOClient], [FIOManager], [detailName], [quantityDetails], [carBrandName], [orderPrice]) VALUES (22, N'Fanova Galina Viktorovna', N'Panov Gleb Pankovich', N'Headlights', 62, N'Renault Fluence Z.E.', 263400.0000)
INSERT [dbo].[Manager_Operations] ([idOrder], [FIOClient], [FIOManager], [detailName], [quantityDetails], [carBrandName], [orderPrice]) VALUES (23, N'Ranin Mark Titovich', N'Kiriyakov Gleb Mihailovich', N'Cooling System', 24, N'Ford Focus Electric', 645800.0000)
INSERT [dbo].[Manager_Operations] ([idOrder], [FIOClient], [FIOManager], [detailName], [quantityDetails], [carBrandName], [orderPrice]) VALUES (24, N'Alimov Aleksandr Aleksandrovich', N'Han Nikolay Grigorievich', N'Electric motor', 3, N'Honda FitEV', 468000.0000)
INSERT [dbo].[Manager_Operations] ([idOrder], [FIOClient], [FIOManager], [detailName], [quantityDetails], [carBrandName], [orderPrice]) VALUES (25, N'Inushkin Mark Sergeevich', N'Warkunin Foma Lampovich', N'Storage Battery', 9, N'Volvo C30 Electric', 87930.0000)
INSERT [dbo].[Manager_Operations] ([idOrder], [FIOClient], [FIOManager], [detailName], [quantityDetails], [carBrandName], [orderPrice]) VALUES (26, N'Savin Garik Hanovich', N'Kuzmin Jamik Kirovich', N'Wheels', 18, N'Mitsubishi I MiEV', 532049.0000)
INSERT [dbo].[Manager_Operations] ([idOrder], [FIOClient], [FIOManager], [detailName], [quantityDetails], [carBrandName], [orderPrice]) VALUES (27, N'Hanov Mihail Viktorovich', N'Dunin Sergey Valerievich', N'Transmission', 26, N'Tesla Roadster', 195304.0000)
INSERT [dbo].[Manager_Operations] ([idOrder], [FIOClient], [FIOManager], [detailName], [quantityDetails], [carBrandName], [orderPrice]) VALUES (28, N'Pakina Irina Borisovna', N'Lunov Jek Uronovich', N'Electric motor', 5, N'BMW Active C', 349580.0000)
SET IDENTITY_INSERT [dbo].[Manager_Operations] OFF
GO
SET IDENTITY_INSERT [dbo].[Order] ON 

INSERT [dbo].[Order] ([NZ], [NK (FK)], [ID_manager (FK)], [ID_auto (FK)], [Date], [Sum]) VALUES (1, 5, 2, 3, CAST(N'2022-08-20' AS Date), 528000.0000)
INSERT [dbo].[Order] ([NZ], [NK (FK)], [ID_manager (FK)], [ID_auto (FK)], [Date], [Sum]) VALUES (2, 9, 2, 5, CAST(N'2021-03-18' AS Date), 342000.0000)
INSERT [dbo].[Order] ([NZ], [NK (FK)], [ID_manager (FK)], [ID_auto (FK)], [Date], [Sum]) VALUES (3, 8, 2, 2, CAST(N'2019-11-15' AS Date), 48590.0000)
INSERT [dbo].[Order] ([NZ], [NK (FK)], [ID_manager (FK)], [ID_auto (FK)], [Date], [Sum]) VALUES (4, 7, 3, 6, CAST(N'2018-06-19' AS Date), 156200.0000)
INSERT [dbo].[Order] ([NZ], [NK (FK)], [ID_manager (FK)], [ID_auto (FK)], [Date], [Sum]) VALUES (5, 1, 3, 1, CAST(N'2015-02-16' AS Date), 246930.0000)
INSERT [dbo].[Order] ([NZ], [NK (FK)], [ID_manager (FK)], [ID_auto (FK)], [Date], [Sum]) VALUES (6, 2, 4, 7, CAST(N'2017-07-21' AS Date), 98530.0000)
INSERT [dbo].[Order] ([NZ], [NK (FK)], [ID_manager (FK)], [ID_auto (FK)], [Date], [Sum]) VALUES (7, 4, 4, 8, CAST(N'2016-03-14' AS Date), 742842.0000)
INSERT [dbo].[Order] ([NZ], [NK (FK)], [ID_manager (FK)], [ID_auto (FK)], [Date], [Sum]) VALUES (8, 6, 5, 9, CAST(N'2010-05-22' AS Date), 125302.0000)
INSERT [dbo].[Order] ([NZ], [NK (FK)], [ID_manager (FK)], [ID_auto (FK)], [Date], [Sum]) VALUES (9, 10, 5, 10, CAST(N'2009-09-18' AS Date), 348291.0000)
INSERT [dbo].[Order] ([NZ], [NK (FK)], [ID_manager (FK)], [ID_auto (FK)], [Date], [Sum]) VALUES (10, 3, 6, 4, CAST(N'2013-04-16' AS Date), 164205.0000)
INSERT [dbo].[Order] ([NZ], [NK (FK)], [ID_manager (FK)], [ID_auto (FK)], [Date], [Sum]) VALUES (11, 9, 2, 4, CAST(N'2019-05-16' AS Date), 420159.0000)
INSERT [dbo].[Order] ([NZ], [NK (FK)], [ID_manager (FK)], [ID_auto (FK)], [Date], [Sum]) VALUES (12, 6, 2, 7, CAST(N'2018-12-19' AS Date), 285120.0000)
INSERT [dbo].[Order] ([NZ], [NK (FK)], [ID_manager (FK)], [ID_auto (FK)], [Date], [Sum]) VALUES (13, 3, 7, 2, CAST(N'2015-11-05' AS Date), 256403.0000)
INSERT [dbo].[Order] ([NZ], [NK (FK)], [ID_manager (FK)], [ID_auto (FK)], [Date], [Sum]) VALUES (14, 3, 8, 6, CAST(N'2019-03-14' AS Date), 17394.0000)
INSERT [dbo].[Order] ([NZ], [NK (FK)], [ID_manager (FK)], [ID_auto (FK)], [Date], [Sum]) VALUES (15, 3, 9, 7, CAST(N'2014-08-20' AS Date), 342010.0000)
INSERT [dbo].[Order] ([NZ], [NK (FK)], [ID_manager (FK)], [ID_auto (FK)], [Date], [Sum]) VALUES (16, 3, 10, 8, CAST(N'2020-09-12' AS Date), 402594.0000)
INSERT [dbo].[Order] ([NZ], [NK (FK)], [ID_manager (FK)], [ID_auto (FK)], [Date], [Sum]) VALUES (17, 11, 7, 7, CAST(N'2022-09-12' AS Date), 253653.0000)
INSERT [dbo].[Order] ([NZ], [NK (FK)], [ID_manager (FK)], [ID_auto (FK)], [Date], [Sum]) VALUES (18, 12, 3, 3, CAST(N'2021-09-12' AS Date), 376432.0000)
INSERT [dbo].[Order] ([NZ], [NK (FK)], [ID_manager (FK)], [ID_auto (FK)], [Date], [Sum]) VALUES (19, 13, 2, 2, CAST(N'2019-09-12' AS Date), 754325.0000)
INSERT [dbo].[Order] ([NZ], [NK (FK)], [ID_manager (FK)], [ID_auto (FK)], [Date], [Sum]) VALUES (20, 14, 6, 9, CAST(N'2018-09-12' AS Date), 754900.0000)
SET IDENTITY_INSERT [dbo].[Order] OFF
GO
SET IDENTITY_INSERT [dbo].[Phone] ON 

INSERT [dbo].[Phone] ([NT], [NK (FK)], [Type], [Phone]) VALUES (1, 1, N'Личный', N'+7-952-924-14-92')
INSERT [dbo].[Phone] ([NT], [NK (FK)], [Type], [Phone]) VALUES (2, 1, N'Домашний', N'+7-499-253-93-07')
INSERT [dbo].[Phone] ([NT], [NK (FK)], [Type], [Phone]) VALUES (3, 2, N'Личный', N'+7-952-253-93-07')
INSERT [dbo].[Phone] ([NT], [NK (FK)], [Type], [Phone]) VALUES (4, 3, N'Личный', N'+7-903-185-10-83')
INSERT [dbo].[Phone] ([NT], [NK (FK)], [Type], [Phone]) VALUES (5, 4, N'Домашний', N'+7-499-873-67-83')
INSERT [dbo].[Phone] ([NT], [NK (FK)], [Type], [Phone]) VALUES (6, 5, N'Личный', N'+7-906-102-83-19')
INSERT [dbo].[Phone] ([NT], [NK (FK)], [Type], [Phone]) VALUES (7, 7, N'Домашний', N'+7-495-346-02-16')
INSERT [dbo].[Phone] ([NT], [NK (FK)], [Type], [Phone]) VALUES (8, 8, N'Рабочий', N'+7-495-924-14-92')
INSERT [dbo].[Phone] ([NT], [NK (FK)], [Type], [Phone]) VALUES (9, 9, N'Домашний', N'+7-915-932-28-04')
INSERT [dbo].[Phone] ([NT], [NK (FK)], [Type], [Phone]) VALUES (10, 10, N'Личный', N'+7-982-293-15-26')
SET IDENTITY_INSERT [dbo].[Phone] OFF
GO
ALTER TABLE [dbo].[Car]  WITH CHECK ADD  CONSTRAINT [FK_Car_Client] FOREIGN KEY([NK (FK)])
REFERENCES [dbo].[Client] ([NK])
GO
ALTER TABLE [dbo].[Car] CHECK CONSTRAINT [FK_Car_Client]
GO
ALTER TABLE [dbo].[Car_Details]  WITH CHECK ADD  CONSTRAINT [FK_Car_Details_Car] FOREIGN KEY([ID_car (FK)])
REFERENCES [dbo].[Car] ([ID_car])
GO
ALTER TABLE [dbo].[Car_Details] CHECK CONSTRAINT [FK_Car_Details_Car]
GO
ALTER TABLE [dbo].[Car_Details]  WITH CHECK ADD  CONSTRAINT [FK_Car_Details_Details] FOREIGN KEY([ID_details (FK)])
REFERENCES [dbo].[Details] ([ID_details])
GO
ALTER TABLE [dbo].[Car_Details] CHECK CONSTRAINT [FK_Car_Details_Details]
GO
ALTER TABLE [dbo].[Details_Order]  WITH CHECK ADD  CONSTRAINT [FK_Details_Order_Details] FOREIGN KEY([ID_details (FK)])
REFERENCES [dbo].[Details] ([ID_details])
GO
ALTER TABLE [dbo].[Details_Order] CHECK CONSTRAINT [FK_Details_Order_Details]
GO
ALTER TABLE [dbo].[Details_Order]  WITH CHECK ADD  CONSTRAINT [FK_Details_Order_Order] FOREIGN KEY([NZ (FK)])
REFERENCES [dbo].[Order] ([NZ])
GO
ALTER TABLE [dbo].[Details_Order] CHECK CONSTRAINT [FK_Details_Order_Order]
GO
ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [FK_Order_Car] FOREIGN KEY([ID_auto (FK)])
REFERENCES [dbo].[Car] ([ID_car])
GO
ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [FK_Order_Car]
GO
ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [FK_Order_Client] FOREIGN KEY([NK (FK)])
REFERENCES [dbo].[Client] ([NK])
GO
ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [FK_Order_Client]
GO
ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [FK_Order_Manager] FOREIGN KEY([ID_manager (FK)])
REFERENCES [dbo].[Manager] ([ID_manager])
GO
ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [FK_Order_Manager]
GO
ALTER TABLE [dbo].[Phone]  WITH CHECK ADD  CONSTRAINT [FK_Phone_Client] FOREIGN KEY([NK (FK)])
REFERENCES [dbo].[Client] ([NK])
GO
ALTER TABLE [dbo].[Phone] CHECK CONSTRAINT [FK_Phone_Client]
GO
USE [master]
GO
ALTER DATABASE [diplomDB] SET  READ_WRITE 
GO

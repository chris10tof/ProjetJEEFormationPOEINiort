USE [RECETTES_GOURMANDES]
GO
/****** Object:  Table [dbo].[AssociationCommentaire]    Script Date: 23/04/2019 10:22:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[AssociationCommentaire](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[personne_id] [int] NOT NULL,
	[plat_id] [int] NOT NULL,
	[restaurant_id] [int] NOT NULL,
	[commentaire_id] [int] NOT NULL,
 CONSTRAINT [PK_Association] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Categorie]    Script Date: 23/04/2019 10:22:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Categorie](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nom] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Categorie] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Commande]    Script Date: 23/04/2019 10:22:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Commande](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[table_id] [int] NOT NULL,
	[plat_id] [int] NOT NULL,
	[nbre_plat] [int] NOT NULL,
 CONSTRAINT [PK_Commande] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Commentaire]    Script Date: 23/04/2019 10:22:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Commentaire](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[contenu] [text] NOT NULL,
	[date] [datetime] NOT NULL,
	[note] [numeric](4, 2) NOT NULL,
 CONSTRAINT [PK_Commentaire] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Etat]    Script Date: 23/04/2019 10:22:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Etat](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[couleur] [varchar](6) NOT NULL,
	[etat] [varchar](8) NOT NULL,
 CONSTRAINT [PK_Etat] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Inscription]    Script Date: 23/04/2019 10:22:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Inscription](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[commentaire] [varchar](100) NOT NULL,
	[personne_id] [int] NOT NULL,
	[restaurant_id] [int] NOT NULL,
 CONSTRAINT [PK_Inscription] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Personne]    Script Date: 23/04/2019 10:22:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Personne](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nom] [varchar](50) NOT NULL,
	[prenom] [varchar](50) NOT NULL,
	[email] [varchar](50) NOT NULL,
	[mdp] [varchar](50) NOT NULL,
	[uri_avatar] [varchar](100) NULL,
	[role_id] [int] NOT NULL,
 CONSTRAINT [PK_Personne] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Plat]    Script Date: 23/04/2019 10:22:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Plat](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nom] [varchar](50) NOT NULL,
	[description] [varchar](100) NOT NULL,
	[prix] [numeric](8, 2) NOT NULL,
	[recette] [text] NOT NULL,
	[uri_image] [varchar](100) NULL,
	[categorie_id] [int] NOT NULL,
	[nbre_commande_totale] [int] NULL,
 CONSTRAINT [PK_Plat] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Reservation]    Script Date: 23/04/2019 10:22:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Reservation](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[table_id] [int] NOT NULL,
	[nom] [varchar](20) NOT NULL,
	[tel] [varchar](10) NOT NULL,
	[nbre_personnes] [int] NOT NULL,
 CONSTRAINT [PK_Reservation] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Restaurant]    Script Date: 23/04/2019 10:22:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Restaurant](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[localisation] [varchar](10) NOT NULL,
	[nbre_table] [int] NOT NULL,
	[uri_resto] [varchar](100) NULL,
 CONSTRAINT [PK_Restaurant] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Role]    Script Date: 23/04/2019 10:22:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nom] [varchar](10) NOT NULL,
 CONSTRAINT [PK_Role] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Table]    Script Date: 23/04/2019 10:22:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Table](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[restaurant_id] [int] NOT NULL,
	[etat_id] [int] NOT NULL,
 CONSTRAINT [PK_Table] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[AssociationCommentaire]  WITH CHECK ADD  CONSTRAINT [FK_Association_Commentaire] FOREIGN KEY([commentaire_id])
REFERENCES [dbo].[Commentaire] ([id])
GO
ALTER TABLE [dbo].[AssociationCommentaire] CHECK CONSTRAINT [FK_Association_Commentaire]
GO
ALTER TABLE [dbo].[AssociationCommentaire]  WITH CHECK ADD  CONSTRAINT [FK_Association_Personne] FOREIGN KEY([personne_id])
REFERENCES [dbo].[Personne] ([id])
GO
ALTER TABLE [dbo].[AssociationCommentaire] CHECK CONSTRAINT [FK_Association_Personne]
GO
ALTER TABLE [dbo].[AssociationCommentaire]  WITH CHECK ADD  CONSTRAINT [FK_AssociationCommentaire_Plat] FOREIGN KEY([plat_id])
REFERENCES [dbo].[Plat] ([id])
GO
ALTER TABLE [dbo].[AssociationCommentaire] CHECK CONSTRAINT [FK_AssociationCommentaire_Plat]
GO
ALTER TABLE [dbo].[AssociationCommentaire]  WITH CHECK ADD  CONSTRAINT [FK_AssociationCommentaire_Restaurant] FOREIGN KEY([restaurant_id])
REFERENCES [dbo].[Restaurant] ([id])
GO
ALTER TABLE [dbo].[AssociationCommentaire] CHECK CONSTRAINT [FK_AssociationCommentaire_Restaurant]
GO
ALTER TABLE [dbo].[Commande]  WITH CHECK ADD  CONSTRAINT [FK_Commande_Plat] FOREIGN KEY([plat_id])
REFERENCES [dbo].[Plat] ([id])
GO
ALTER TABLE [dbo].[Commande] CHECK CONSTRAINT [FK_Commande_Plat]
GO
ALTER TABLE [dbo].[Commande]  WITH CHECK ADD  CONSTRAINT [FK_Commande_Table] FOREIGN KEY([table_id])
REFERENCES [dbo].[Table] ([id])
GO
ALTER TABLE [dbo].[Commande] CHECK CONSTRAINT [FK_Commande_Table]
GO
ALTER TABLE [dbo].[Inscription]  WITH CHECK ADD  CONSTRAINT [FK_Inscription_Personne] FOREIGN KEY([personne_id])
REFERENCES [dbo].[Personne] ([id])
GO
ALTER TABLE [dbo].[Inscription] CHECK CONSTRAINT [FK_Inscription_Personne]
GO
ALTER TABLE [dbo].[Inscription]  WITH CHECK ADD  CONSTRAINT [FK_Inscription_Restaurant] FOREIGN KEY([restaurant_id])
REFERENCES [dbo].[Restaurant] ([id])
GO
ALTER TABLE [dbo].[Inscription] CHECK CONSTRAINT [FK_Inscription_Restaurant]
GO
ALTER TABLE [dbo].[Personne]  WITH CHECK ADD  CONSTRAINT [FK_Personne_Role] FOREIGN KEY([role_id])
REFERENCES [dbo].[Role] ([id])
GO
ALTER TABLE [dbo].[Personne] CHECK CONSTRAINT [FK_Personne_Role]
GO
ALTER TABLE [dbo].[Plat]  WITH CHECK ADD  CONSTRAINT [FK_Plat_Categorie] FOREIGN KEY([categorie_id])
REFERENCES [dbo].[Categorie] ([id])
GO
ALTER TABLE [dbo].[Plat] CHECK CONSTRAINT [FK_Plat_Categorie]
GO
ALTER TABLE [dbo].[Reservation]  WITH CHECK ADD  CONSTRAINT [FK_Reservation_Table] FOREIGN KEY([table_id])
REFERENCES [dbo].[Table] ([id])
GO
ALTER TABLE [dbo].[Reservation] CHECK CONSTRAINT [FK_Reservation_Table]
GO
ALTER TABLE [dbo].[Table]  WITH CHECK ADD  CONSTRAINT [FK_Table_Etat] FOREIGN KEY([etat_id])
REFERENCES [dbo].[Etat] ([id])
GO
ALTER TABLE [dbo].[Table] CHECK CONSTRAINT [FK_Table_Etat]
GO

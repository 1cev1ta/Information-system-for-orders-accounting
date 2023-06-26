<!-- Improved compatibility of back to top link: See: https://github.com/othneildrew/Best-README-Template/pull/73 -->
<a name="readme-top"></a>
<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Don't forget to give the project a star!
*** Thanks again! Now go create something AMAZING! :D
-->



<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]



<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/1cev1ta/Information-system-for-orders-accounting">
    <img src="src/assets/program_logo.png" alt="Logo" width="60" height="60">
  </a>

  <h3 align="center">Information system for orders accounting</h3>

  <p align="center">
    Информационная система учета заказов на запчасти для электроавтомобилей
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li><a href="#about-the-project">About The Project</a></li>
    <li><a href="#database-engineering">Database Engineering</a></li>
    <li><a href="#testing-database">Testing Database</a></li>
    <li><a href="#built-with">Build With</a></li>
    <li><a href="#creating-ui">Creating UI</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#references">References</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

 <a href="https://github.com/1cev1ta/Information-system-for-orders-accounting">
    <img src="images\diagram_company.png" alt="Logo">
  </a>

There are many great JavaFX project templates available on GitHub; however, I didn't find one that really met my needs, so I created this program. This is a program from my thesis qualification work and it provides functionality for the work of managers of the company's sales department.

The purpose of my graduation work was to increase the efficiency of the company through the development and implementation of an information system for accounting for orders for spare parts for electric vehicles.

The tasks of the work were:
* Conduct an analysis of the activities of the company for the sale of spare parts for electric vehicles;
* Choose methods and tools for system development;
* Design a database to record orders for spare parts for electric vehicles;
* Develop a user interface for a team of company managers and an administrator;
* Substantiate decisions to ensure the operational and information security of the developed system;
* Conduct an economic calculation of the costs of developing the system.

<a href="https://github.com/1cev1ta/Information-system-for-orders-accounting">
    <img src="images\zadachi_screen.png" alt="Logo">
  </a>

This repository provides a direct implementation of the user interface.
In the future, the project can be developed and supplemented with new commits.

<p align="right">(<a href="#about-the-project">back to top</a>)</p>

### Database Engineering

This section describes the design steps of the project database. 

* As a result of the first phase of database design-conceptual design of the model, a conceptual database model was created in the Chen standard, which displays the entities, attributes and relationships between them.

<a href="https://github.com/1cev1ta/Information-system-for-orders-accounting">
<img src="images\model_chena.png" alt="Logo">
</a>

* As a result of the second stage of database design - logical design of the data model, a database schema was created in the IDEF1X standard in the ERwin environment, which contains tables, relationships between tables, attributes and restrictions.

<a href="https://github.com/1cev1ta/Information-system-for-orders-accounting">
<img src="images\model_logicheskaya.png" alt="Logo">
</a>



* The next stage of work is the selection of DBMS. DBMS is a fundamental component of the information system, on which its performance, reliability and scalability depend. The choice of a suitable DBMS should be based on a number of factors including functionality, performance, scalability, security, GUI convenience, and integration with other applications. The table on the slide shows a comparison of three popular DBMSs. Looking at it, we can conclude that Microsoft SQL Server and Oracle Database look better against the PostgreSQL background. In addition, Microsoft SQL Server also has a couple of obvious advantages - a more understandable and easy-to-use graphical interface and integration with other Microsoft products such as Excel, Power BI, Azure. I also personally worked with Microsoft SQL Server and have a positive user experience, which is why this particular DBMS was chosen in this work.

<a href="https://github.com/1cev1ta/Information-system-for-orders-accounting">
<img src="images\choose_subd.png" alt="Logo">
</a>

* After the final selection of the DBMS, I generated a database in it and carried out the transfer of the final version of the logical model, thereby starting the physical design stage. This slide shows a physical data model built in Microsoft SQL Server Management Studio. All information in the database is divided into tables, which are the entities of a particular business object or process. The diagram shows the relationships between the tables of the created database, as well as the primary and foreign keys of the tables.

<a href="https://github.com/1cev1ta/Information-system-for-orders-accounting">
<img src="images\fiz_sheme.png" alt="Logo">
</a>

<p align="right">(<a href="#about-the-project">back to top</a>)</p>

### Testing Database

Testing the operation of the database was carried out using SQL queries. The slide shows two queries that clearly show that the data is displayed correctly and the implementation of business logic is structured correctly.
* The first query displays detailed information about customers who have ordered more than 150,000.
* The second query displays all parts that were sold until 2020 with a part price of more than 500,000.

<a href="https://github.com/1cev1ta/Information-system-for-orders-accounting">
<img src="images\testing_database.png" alt="Logo">
</a>

<p align="right">(<a href="#about-the-project">back to top</a>)</p>

### Built With

This section  contains all the main frameworks/libraries used in the project development process:

* [![Java][Java.com]][Java-url]
* [![IntellijIDEA][IntellijIDEA.com]][IntellijIDEA-url]
* [![SceneBuilder][SceneBuilder.com]][SceneBuilder-url]
* [![Figma][Figma.com]][Figma-url]
* [![MaterialFX][MaterialFX.com]][MaterialFX-url]

The IntelliJ IDEA development environment was selected to implement the functional part of the user interface.
The JavaFX platform was used to write the code.
The visual part of the interface was created in Scene Builder, a special tool for visual design UI for JavaFX applications.


The joint use of IntellijIDEA and SceneBuilder in conjunction with the JavaFX platform has several advantages.
If we talk about the IntellijIDEA development environment, then this is:
* full compatibility of the environment with the Java language on which the JavaFX platform is built
* a variety of tools for working with JavaFX;
* easy-to-use environment features for the development team.

The advantages of SceneBuilder are that it:
* allows developers to quickly create PIs;
* integrates with IntelliJ IDEA and natively supports JavaFX;
* has a convenient visual representation of the user interface.

<a href="https://github.com/1cev1ta/Information-system-for-orders-accounting">
<img src="images\table_sr.png" alt="Logo">
</a>

<p align="right">(<a href="#about-the-project">back to top</a>)</p>

<!-- USAGE EXAMPLES -->
## Creating UI

As a result of working on the creation of the user interface, several windows of the program were created. Logically, the program is divided into three parts: the introductory user authorization window, the manager working window and the administrator working panel.

- The opening window of the application is as follows.
At the initial stage, the program asks the user to enter information for authorization in the application: login and password.
In the program, you can log in as a manager or administrator.

<a href="https://github.com/1cev1ta/Information-system-for-orders-accounting">
<img src="images\autorization_screen.png" alt="Logo">
</a>

When you enter the data that gives access to the manager level, you go to a new application window - the manager work window.

Conditionally, the manager's work window can be divided into three functional units: the area for adding/updating order data, the order table with the order search/delete function, and the result console to display information about the success/failure of interim operations.
The manager's work window has extensive functionality, which includes:
1. [x] Add a new order
2. [x] Updating Existing Order Data
3. [x] Delete an irrelevant order
4. [x] Search for an individual order by its No.
5. [x] Output of all orders issued to date

All these functions allow the manager to work efficiently with customer orders stored in the database.

<a href="https://github.com/1cev1ta/Information-system-for-orders-accounting">
<img src="images\window_manager.png" alt="Logo">
</a>

When we pass authorization in the application as an administrator, we get into the administrator's working window.

You can see the general view of the window below. It has a side menu with the selection of a specific table from the database. The administrator can select any of the tables: 
* Order
* Manager
* Customer
* Details 
* Car

With this, he has an advantage over the manager, who has access only to the order table. This ensures the integrity of the data and its safety from unauthorized access.

<a href="https://github.com/1cev1ta/Information-system-for-orders-accounting">
<img src="images\window_administrator.png" alt="Logo">
</a>

After selecting a specific menu item, the corresponding table opens in front of the administrator and the functions for adding/updating data in the table, as well as deleting and searching for data in the table become available. On the slide, you can see what the administrator window looks like when you select a menu item to work with the Order table.

<a href="https://github.com/1cev1ta/Information-system-for-orders-accounting">
<img src="images\choose_zakaz_admin.png" alt="Logo">
</a>

_Some user interface elements were created based on the MaterialFX library. If you want to use it in your project then here is the link: [MaterialFX](https://github.com/palexdev/MaterialFX)_

<p align="right">(<a href="#about-the-project">back to top</a>)</p>

<!-- CONTACT -->
## Contact

Boris Spirin - [telegram](https://t.me/spi_rin) - email: bs_dev@bk.com

My LinkedIn Profile - [tap here](https://www.linkedin.com/in/boris-spirin-74ab55280/)

Project Link: [https://github.com/1cev1ta/Information-system-for-orders-accounting](https://github.com/1cev1ta/Information-system-for-orders-accounting)

<p align="right">(<a href="#about-the-project">back to top</a>)</p>

<!-- ACKNOWLEDGMENTS -->
## References

Below I want to list the useful resources that helped me in developing the project. Perhaps they can help you too!

* [Oracle official documentation for JavaFX](https://docs.oracle.com/javafx/2/)
* [Official Microsoft SQL Documentation](https://learn.microsoft.com/ru-ru/sql/?view=sql-server-ver16)
* [Official Microsoft Java Documentation](https://learn.microsoft.com/ru-ru/java/)


I would also like to recommend some useful books for programmers:
* [Martin P. Clean code: creation, analysis and refactoring.]
* [Bloch, J. Effective Java: Programming Language Guide.]
* [Shildt, G. Java. Full guidance.]

<p align="right">(<a href="#about-the-project">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/1cev1ta/Information-system-for-orders-accounting.svg?style=for-the-badge
[contributors-url]: https://github.com/1cev1ta/Information-system-for-orders-accounting/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/1cev1ta/Information-system-for-orders-accounting.svg?style=for-the-badge
[forks-url]: https://github.com/1cev1ta/Information-system-for-orders-accounting/network/members
[stars-shield]: https://img.shields.io/github/stars/1cev1ta/Information-system-for-orders-accounting.svg?style=for-the-badge
[stars-url]: https://github.com/1cev1ta/Information-system-for-orders-accounting/stargazers
[issues-shield]: https://img.shields.io/github/issues/1cev1ta/Information-system-for-orders-accounting.svg?style=for-the-badge
[issues-url]: https://github.com/1cev1ta/Information-system-for-orders-accounting/issues
[license-shield]: https://img.shields.io/github/license/1cev1ta/Information-system-for-orders-accounting.svg?style=for-the-badge
[license-url]: https://github.com/1cev1ta/Information-system-for-orders-accounting/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/boris-spirin-74ab55280
[product-screenshot]: images/screenshot.png
[Java.com]: https://img.shields.io/badge/java-FF2D20?style=for-the-badge&logo=java&logoColor=white
[Java-url]: https://www.java.com/
[IntellijIDEA.com]: https://img.shields.io/badge/IntellijIDEA-20232A?style=for-the-badge&logo=intellijidea&logoColor=61DAFB
[IntellijIDEA-url]: https://www.jetbrains.com/idea/
[SceneBuilder.com]: https://img.shields.io/badge/Scene%20Builder-35495E?style=for-the-badge&logo=scene&logoColor=4FC08D
[SceneBuilder-url]: https://gluonhq.com/products/scene-builder/
[Figma.com]: https://img.shields.io/badge/Figma-DD0031?style=for-the-badge&logo=figma&logoColor=white
[Figma-url]: https://www.figma.com/
[MaterialFX.com]: https://img.shields.io/badge/MaterialFX-0769AD?style=for-the-badge&logo=matealfx&logoColor=white
[MaterialFX-url]: https://github.com/palexdev/MaterialFX

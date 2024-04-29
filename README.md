<!-- PROJECT LOGO -->
<br />
<div align="center">
    <img src="/src/main/resources/img/tarnas-center-logo.png" alt="Logo" width="80" height="80" style="background-color:white; border-radius: 10%;" >

<h3 align="center">TARNAS</h3>
  <p align="center">
    A TrAnslator for RNA Secondary structure formats
    </p>
</div>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#credits">Credits</a></li>
    <li><a href="#contact-information">Contact Information</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

Comparison of molecules, more specifically of RNA secondary structures is essential for several studies including RNA prediction and evolution.
These structures are stored in text files which may have different representation formats. Some formats also admit their own header, which is a set of additional information for that molecule.
Multiple representation of RNA secondary structures through the use of multiple formats becomes a major problem when those who always work with a spe- cific format find themselves working with masses of data of quite a different format. This constrains the user to perform manual translation work, which is disadvantageous for 2 main reasons: the time taken to perform the translation and the difficulty in the translation itself, hence the ease in making errors during this process. This is where TARNAS comes in: an innovative translator of RNA secondary structure formats that frees users from always using a specific format and thus allowing them to switch from one format to another quickly and easily. With TARNAS, the problem of additional information is also solved: it provides cleanup options to allow the user to remove from the file any information he or she deems unnecessary.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



### Built With

TARNAS was developed with:

* [Java][Java-url]
* [ANTLR4][ANTLR-url]
* [Springboot][Springboot-url]
* [Maven][Maven-url]
* [JavaFX][JavaFX-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- GETTING STARTED -->
## Getting Started

This is an example of how you may give instructions on setting up your project locally.
To get a local copy up and running follow these simple example steps.

### Prerequisites

To run TARNAS, the following requirements must be met.
* Java 19
  <!--```sh
  npm install npm@latest -g
  ```-->
If you want to run the program via Maven:
* Maven

### Installation

You can install TARNAS in several ways:

* Clone the repo
   ```sh
   git clone https://github.com/bdslab/TARNAS
   ```
* Alternatively, download the latest release from [TARNAS latest release](https://github.com/bdslab/TARNAS/releases/tag/v1.0.0). Here you can download:
  * TARNAS.jar
  * Source code (zip)
  * Surce code (tar.gz)
    
  It's recommended to download just the jar file `TARNAS.jar`.


<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- USAGE EXAMPLES -->
## Usage
* If you cloned the repo, you can use `Maven` to execute TARNAS.
<br>
Position yourself inside the `TARNAS folder`, which contains the `pom.xml`, and type the following command:
  ```sh
  mvn clean javafx:run
  ```
* If you downloaded the `TARNAS.jar`from the latest release, you can use `Java` to execute TARNAS.
  <br>
  Position yourself inside the folder that contains the jar executable file, and type the following command:
  ```sh
  java -jar TARNAS.jar
  ```
<br>
TARNAS works as follows:

1. It takes a `text file as input` representing an RNA secondary structure. the file consists of a header (described by comments) and a body (which is the molecule in that representation).

   The user can upload:
    * a text file via the `ADD FILE button`.
    * a folder containing multiple text files via the `ADD FOLDER button`.
    * or directly write the contents of the file via `EDIT FILE button`. In this case, a window will appear where the user can type in the content of the molecule to be represented. Once this has been represented, the programme will ask the user to enter a name for this file (by default example.ct is entered)
    <h3>All uploaded files must have the same format. TARNAS does not provide translation or cleaning options between multiple files of different formats.</h2>
   The user can also remove all uploaded files via the `RESET button`. 
2. Once one or more files have been uploaded, the user can perform either the `cleaning operation` or the `translation operation` (not both atomically).

   This means that cleaning and translation cannot be done at the same time. In this case, it is necessary to perform the cleanup operation first, then reload the cleaned files, and then perform any translation.
<br><br>
   When one or more files have been loaded within the program, they are displayed within a table that has the following header:
  <h4 align="center">| File Name | Format | Remove | Preview |</h4>

   Each row in this table will therefore contain an uploaded file with the following information and options:
   * **File Name**: the name of the uploaded file
   * **Format**: the file format based on the file content
   * **Remove**: an option to delete that file
   * **Preview**: an option to visualize the content of the file
<br><br>
3. `CLEANING OPTIONS`: they are on the `left side` of TARNAS and allow the user to:
   * `remove all comments`: any comments that form the header are removed.
   * `remove lines containing`: the user inputs a `word` and every comment that forms the header and contains the `word` given as input by the user is deleted.
   * `remove empty lines:` all lines that contain blank spaces (spaces, tabs) are deleted.
   * `merge lines`: this option is enabled only in Dot-Bracket format (with or without sequence). Since in these formats the sequence and structure can be represented on multiple lines, therefore the option is provided to `merge` all lines into a single line.

   Once the desired cleaning options have been selected, you must press the `CLEAN button` to start cleaning on the uploaded files.

   At this point, the user will be asked to choose where to save the cleaned files, and if successful, a report will be shown of the number of files cleaned and saved in the location specified by the user.
4. `TRANSLATION OPTIONS`: TODO Piero
 


<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!--## Demo-->
 

<!-- ROADMAP
## Roadmap

- [x] Add Changelog
- [x] Add back to top links
- [ ] Add Additional Templates w/ Examples
- [ ] Add "components" document to easily copy & paste sections of the readme
- [ ] Multi-language Support
    - [ ] Chinese
    - [ ] Spanish

See the [open issues](https://github.com/othneildrew/Best-README-Template/issues) for a full list of proposed features (and known issues).

<p align="right">(<a href="#readme-top">back to top</a>)</p>-->



<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- LICENSE -->
## License

Distributed under the GNU License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



## Credits

TARNAS is developed and tested by:

- Piero Hierro, University of Camerino
- Piermichele Rosati, University of Camerino
- Luca Tesei, University of Camerino

TARNAS is tested by:

- Michela Quadrini, University of Camerino
<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Contact Information

Please report any issue to luca.tesei@unicam.it or to Luca Tesei, Polo
Informatico, via Madonna delle Carceri 7, 62032 Camerino (MC) Italy.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ACKNOWLEDGMENTS
## Acknowledgments

Use this space to list resources you find helpful and would like to give credit to. I've included a few of my favorites to kick things off!

* [Choose an Open Source License](https://choosealicense.com)
* [GitHub Emoji Cheat Sheet](https://www.webpagefx.com/tools/emoji-cheat-sheet)
* [Malven's Flexbox Cheatsheet](https://flexbox.malven.co/)
* [Malven's Grid Cheatsheet](https://grid.malven.co/)
* [Img Shields](https://shields.io)
* [GitHub Pages](https://pages.github.com)
* [Font Awesome](https://fontawesome.com)
* [React Icons](https://react-icons.github.io/react-icons/search)

<p align="right">(<a href="#readme-top">back to top</a>)</p>-->



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/othneildrew/Best-README-Template.svg?style=for-the-badge
[contributors-url]: https://github.com/othneildrew/Best-README-Template/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/othneildrew/Best-README-Template.svg?style=for-the-badge
[forks-url]: https://github.com/othneildrew/Best-README-Template/network/members
[stars-shield]: https://img.shields.io/github/stars/othneildrew/Best-README-Template.svg?style=for-the-badge
[stars-url]: https://github.com/othneildrew/Best-README-Template/stargazers
[issues-shield]: https://img.shields.io/github/issues/othneildrew/Best-README-Template.svg?style=for-the-badge
[issues-url]: https://github.com/othneildrew/Best-README-Template/issues
[license-shield]: https://img.shields.io/github/license/othneildrew/Best-README-Template.svg?style=for-the-badge
[license-url]: https://github.com/othneildrew/Best-README-Template/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/othneildrew
[product-screenshot]: images/screenshot.png
[Java-url]: https://www.java.com/en/
[Springboot-url]: https://spring.io/projects/spring-boot
[JavaFX-url]: https://openjfx.io
[maven-url]: https://maven.apache.org
[ANTLR-url]: https://www.antlr.org
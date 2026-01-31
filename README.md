# MODELADO DE PLATAFORMAS DISTRIBUIDAS - Trabajo en Equipo

Se necesita node y angular para que funcione, por lo que debe descargarlo.

## Getting started

To make it easy for you to get started with GitLab, here's a list of recommended next steps.

Already a pro? Just edit this README.md and make it your own. Want to make it easy? [Use the template at the bottom](#editing-this-readme)!

## Add your files

- [ ] [Create](https://docs.gitlab.com/ee/user/project/repository/web_editor.html#create-a-file) or [upload](https://docs.gitlab.com/ee/user/project/repository/web_editor.html#upload-a-file) files
- [ ] [Add files using the command line](https://docs.gitlab.com/ee/gitlab-basics/add-file.html#add-a-file-using-the-command-line) or push an existing Git repository with the following command:

```
cd existing_repo
git remote add origin https://gitlab.inf.uva.es/daniema/equipo11.git
git branch -M main
git push -uf origin main
```

## Integrate with your tools

- [ ] [Set up project integrations](https://gitlab.inf.uva.es/daniema/equipo11/-/settings/integrations)

## Collaborate with your team

- [ ] [Invite team members and collaborators](https://docs.gitlab.com/ee/user/project/members/)
- [ ] [Create a new merge request](https://docs.gitlab.com/ee/user/project/merge_requests/creating_merge_requests.html)
- [ ] [Automatically close issues from merge requests](https://docs.gitlab.com/ee/user/project/issues/managing_issues.html#closing-issues-automatically)
- [ ] [Enable merge request approvals](https://docs.gitlab.com/ee/user/project/merge_requests/approvals/)
- [ ] [Set auto-merge](https://docs.gitlab.com/ee/user/project/merge_requests/merge_when_pipeline_succeeds.html)

## Test and Deploy

Use the built-in continuous integration in GitLab.

- [ ] [Get started with GitLab CI/CD](https://docs.gitlab.com/ee/ci/quick_start/index.html)
- [ ] [Analyze your code for known vulnerabilities with Static Application Security Testing (SAST)](https://docs.gitlab.com/ee/user/application_security/sast/)
- [ ] [Deploy to Kubernetes, Amazon EC2, or Amazon ECS using Auto Deploy](https://docs.gitlab.com/ee/topics/autodevops/requirements.html)
- [ ] [Use pull-based deployments for improved Kubernetes management](https://docs.gitlab.com/ee/user/clusters/agent/)
- [ ] [Set up protected environments](https://docs.gitlab.com/ee/ci/environments/protected_environments.html)

***

# Editing this README

When you're ready to make this README your own, just edit this file and use the handy template below (or feel free to structure it however you want - this is just a starting point!). Thanks to [makeareadme.com](https://www.makeareadme.com/) for this template.

## Suggestions for a good README

Every project is different, so consider which of these sections apply to yours. The sections used in the template are suggestions for most open source projects. Also keep in mind that while a README can be too long and detailed, too long is better than too short. If you think your README is too long, consider utilizing another form of documentation rather than cutting out information.

## Name
Choose a self-explaining name for your project.

## Description
Let people know what your project can do specifically. Provide context and add a link to any reference visitors might be unfamiliar with. A list of Features or a Background subsection can also be added here. If there are alternatives to your project, this is a good place to list differentiating factors.

## Badges
On some READMEs, you may see small images that convey metadata, such as whether or not all the tests are passing for the project. You can use Shields to add some to your README. Many services also have instructions for adding a badge.

## Visuals
Depending on what you are making, it can be a good idea to include screenshots or even a video (you'll frequently see GIFs rather than actual videos). Tools like ttygif can help, but check out Asciinema for a more sophisticated method.

## Installation
Within a particular ecosystem, there may be a common way of installing things, such as using Yarn, NuGet, or Homebrew. However, consider the possibility that whoever is reading your README is a novice and would like more guidance. Listing specific steps helps remove ambiguity and gets people to using your project as quickly as possible. If it only runs in a specific context like a particular programming language version or operating system or has dependencies that have to be installed manually, also add a Requirements subsection.

## Usage
Use examples liberally, and show the expected output if you can. It's helpful to have inline the smallest example of usage that you can demonstrate, while providing links to more sophisticated examples if they are too long to reasonably include in the README.

## Support
Tell people where they can go to for help. It can be any combination of an issue tracker, a chat room, an email address, etc.

## Roadmap
If you have ideas for releases in the future, it is a good idea to list them in the README.

## Contributing
State if you are open to contributions and what your requirements are for accepting them.

For people who want to make changes to your project, it's helpful to have some documentation on how to get started. Perhaps there is a script that they should run or some environment variables that they need to set. Make these steps explicit. These instructions could also be useful to your future self.

You can also document commands to lint the code or run tests. These steps help to ensure high code quality and reduce the likelihood that the changes inadvertently break something. Having instructions for running tests is especially helpful if it requires external setup, such as starting a Selenium server for testing in a browser.

## Authors and acknowledgment
Show your appreciation to those who have contributed to the project.

## License
For open source projects, say how it is licensed.

## Project status
If you have run out of energy or time for your project, put a note at the top of the README saying that development has slowed down or stopped completely. Someone may choose to fork your project or volunteer to step in as a maintainer or owner, allowing your project to keep going. You can also make an explicit request for maintainers.

## Documento de puesta en ejecución.

Contexto 

En este archivo, le vamos a dar una explicación breve pero detallada de los distintos pasos que ha de tomar para probar la aplicación 

Es importante recordar, que otras aplicaciones activas, pueden influir en la ejecución del proyecto. 

Ejemplos conocidos de este comportamiento: 

Visual Studio Code y Docker, compitiendo por el uso de puertos 

Distintas instalaciones de java interponiendose en el java Home 

Descargar recursos necesarios. 

Para garantizar el funcionamiento de esta aplicación debe tener descargado los siguientes recursos: JDK con versión 11 o posterior, Apache Maven con versión 3.0 o posterior, Node.js, Node Versión Manager, Angular-CLI, WSL, Docker Desktop y una base de datos Mysql. 

JDK 

Descargue la versión que considere desde esta página:  

Java Downloads | Oracle 

Apache Maven 3.0 

Descargue la versión que considere desde esta página:  

Download Apache Maven – Maven 

Node.js 

Descargue node.js desde esta página:  

Node.js — Ejecuta JavaScript en cualquier parte 

NVM (Node version manager) 

Descárguelo desde alguno de los siguientes repositorios de git:  

https://github.com/nvm-sh/nvm  

https://github.com/coreybutler/nvm-windows 

Use los siguientes comandos para elegir la versión de node que quieras.  

Instala la última versión de node.  

nvm install latest 

Muestra las versiones de node que tenemos.  

nmv list 

Iindicar qué versión de node queremos ejecutar. 

nvm use versión 

 

Angular-CLI 

Instale Angular-Cli  

https://cli.angular.io/ 

https://angular.io/cli 

https://github.com/angular/angular-cli 

Para ello, abrir en entorno de comandos y desde él ejecutar:  

npm install -g @angular/cli 

Para comprobar las versiones instaladas ejecutar: 

ng --version. 

WSL: 

Descargue la versión 2 de WSL, puede hacerlo por línea de comando con:  

wsl –install  

puede seguir los pasos de esta web 

Install WSL | Microsoft Learn  

Docker Desktop: 

sigue los pasos de esta web:  

Windows | Docker Docs 

MySQL: 
Descárguela desde aquí:  

MySQL  

Para configúrarla deberá crear un host y una contraseña, esto es importante para un paso posterior. 

 

Puesta en marcha de contenedores Docker. 

Lo primero que debes hacer es crear la imagen del MySQL, para ello debes seguir los pasos en esta web 

mysql - Official Image | Docker Hub.  

Este primer paso es importante ya que usaremos esa misma base de datos para configurar los accesos de los microservicios. 

El siguiente paso es tomar la aplicación de nuestro repositorio git, esto ya lo tiene todo preparado, lo único que debe hacer es modificar el archivo “application.properties” que están en los microservicios de usuarios, hoteles y reservas para que coincidan las siguientes dos líneas con los valores con los que creaste tu base de datos MySQL. 

spring.datasource.username = 	<<Tu username personal>> 

spring.datasource.password = 	<<Tu contraseña personal>> 

Además también debe cambiar estos valores en el Docker compose, abajo del todo están las partes del MySQL que se debe cambiar, solo debe modificar la contraseña a la que tiene configurada en MySQL, es decir la siguiente línea de hoteles, reservas y usuarios database:  

MYSQL_ROOT_PASSWORD: 	<<Su propia contraseña>> 

Con todo esto ya debería ser capaz de crear los contenedores Docker, para ello, si está usando VSC y tiene los plugins necesarios puedes hacer clic derecho sobre docker-compose.yml y clicar en la opción compose up.  

Este proceso puede llevar tiempo la primera vez, pero cuando acabe podrás ver en Docker desktop los contenedores creados y operativos, el único paso que quedaría seria configurar Kong. 

 

Configuración de Konga. 

Para configurar Konga solo debe entrar en localhost:1337 

Una vez ahí, te pedirán crear un usuario 

Al hacerlo te llevarán a una página en la que debe crear una conexión 

Con la configuración default usaras de nombre Kong y de url http://kong:8001. 

Una vez hecho esto solo debe tomar el snapshot que tenemos en el repositorio (un documento llamado snapshot.json) e importarlo desde la pestaña snapshot.  

Este último paso debería dejarte usar el frontlane de angular inmediatamente pasando por el api Gateway de Kong. 

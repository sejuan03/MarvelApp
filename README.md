# MarvelAPP - Android APP
![](https://1.bp.blogspot.com/-y9uF6UlF5js/W-zjfImVzuI/AAAAAAAAAck/PHkvxzwTBvUkio8RIuBzg2IJjDM4NY5NQCLcBGAs/s1600/Marvel-Heroes.jpg)
## About

MarvelAPP consumes The Marvel Comics API ([MarvelAPI](http://https://developer.marvel.com/documentation/generalinfo "MarvelAPI")). We are obtaining a data model with a list of marvel characters, their description and the comics in which each one appears. This is a test application.

## Arquitecture - Clean Arquitecture 
### Presentation -  UI (Activities and ViewModel)
##### Package
- ui: This package contains both activities of the application, the first one "Main Activity" shows the list of Marvel Characters and the second displays each Marvel Character Details.

### UseCases - Application Actions 
##### Package
- usecases: Contains CharacterUseCase, performs the action of getting the MarvelCharactersList using the interface MarvelRepository

### Domain - Models and Abstractions
##### Package
- domain: Contains the DomaninMarvelCharacter. The model we need to show the MarvelCharactersList and their description
- repository: Interface MarvelRepository. Abstraction of getCharacters from API.

### Data - API Response and Implementation
##### Package
- data.api: MarvelAPI (Interface with path and queryMap to get MarvelApiResponse) and RepositoryImplementation (makes the request with the keyMap to the MarvelAPI. Mapper to get the DomainMarvelCharacter list)
- data.model: DataModels from APIResponse

### Framework 
##### Package
- di.modules: ApiModule Provides Retrofit to create MarvelApi, Characters Module binds MarvelRepository

## Gradle
##### Project: 
- Hilt classpath added to dependencies
##### Module: 
- Plugins: Parcelize, Kapt, dagger.hilt added
- Dependencies: Retrofit, Gson, Picasso and Hilt dependencies added. Viewbinding enabled
- Settings: maven { url 'https://jitpack.io' } into repositories


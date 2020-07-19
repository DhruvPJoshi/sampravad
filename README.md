# soks

A simple java based client-server chat application.

## How to use the scripts

**NOTE:** All scripts are required to be executed from outside the actual project's directory.

### 1. `make.sh`

```
$ ./make.sh project-name your.package.name YourFile.java
```

To create a project root directory with java package structure, and additionally create a java file

- `project-name` (**required**): the root project name, a default java source path will automatically get created inside it (i.e. `src/main/java`)
- `your.package.name` (**optional**): the package name, separated by `.`, for which a folder structure will get created under default source path (i.e. `your/package/name`)
- `YourFile.java` (**optional**): the source file name, which will include a `package` statement

### 2. `build.sh`

```
$ ./build.sh project-name jar-file-name main.class.File
```

It compiles all the java files in a project and packs an executable/non-executable jar file, as required

- `project-name` (**required**): the root project to build
- `jar-file-name` (**optional**): the name of packed `jar` archive, no extension required
- `main.class.File` (**optional**): the fully qualified name of the main class, if you want to pack an executable `jar` archive

### 3. `clean.sh`

```
$ ./clean.sh project-name
```

This cleans all of the previously compiled `class` and `jar` files

- `project-name` (**required**): the root project to clean

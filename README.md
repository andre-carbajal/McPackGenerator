# McPackGenerator

McPackGenerator is a Java application that allows users to compress a selected directory into a .mcpack file. It uses JavaFX for the GUI and Java's built-in zip functionality for compression.

## Installation

### Prerequisites

- JavaFX 17 or higher([Zulu JDK with JavaFX is recommended](https://www.azul.com/downloads/?version=java-17-lts&package=jdk-fx#zulu))

### Option 1: Compile from Source

1. Clone the repository: `git clone https://github.com/andre-carbajal/McPackGenerator.git`
2. Navigate to the project directory: `cd McPackGenerator`
3. Build the project

### Option 2: Download from Releases

1. Go to the [releases page](https://github.com/andre-carbajal/McPackGenerator/releases) of the repository.
2. Download the latest release.

## Usage

1. Ensure you have a JDK that includes JavaFX 17 or higher, or add the necessary JavaFX modules to your JDK.
2. Run the application: `java -jar McPackGenerator.jar`
3. Use the GUI to select a directory and generate a .mcpack file.

## Features

- Select a directory to compress into a .mcpack file.
- The application ignores certain folders like `.git` and `.gitignore` during compression.
- The application provides a GUI for easy usage.

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License

[GNU GENERAL PUBLIC LICENSE Version 3](LICENSE)
# McPackGenerator

McPackGenerator is a Java application that allows users to compress a selected directory into a .mcpack file. It uses JavaFX for the GUI and Java's built-in zip functionality for compression.

## Installation

1. Clone the repository: `git clone https://github.com/andre-carbajal/McPackGenerator.git`
2. Navigate to the project directory: `cd McPackGenerator`
3. Build the project using Gradle: `gradle build`

## Usage

1. Run the application: `java -jar build/libs/McPackGenerator.jar`
2. Use the GUI to select a directory and generate a .mcpack file.

## Features

- Select a directory to compress into a .mcpack file.
- The application ignores certain folders like `.git` and `.gitignore` during compression.
- The application provides a GUI for easy usage.

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License

[GNU GENERAL PUBLIC LICENSE Version 3](LICENSE)
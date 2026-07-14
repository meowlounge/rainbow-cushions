<p align="center">
  <img src="src/main/resources/assets/rainbow-cushions/icon.png" alt="Rainbow Cushion icon" width="128">
</p>

<h1 align="center">Rainbow Cushion</h1>

<p align="center">
  Rename a cushion to <code>jeb_</code>. It turns rainbow.
</p>

<p align="center">
  <a href="https://modrinth.com/mod/rainbowcushion"><img src="https://img.shields.io/badge/Modrinth-Download-00AF5C?logo=modrinth&logoColor=white" alt="Download on Modrinth"></a>
  <img src="https://img.shields.io/badge/Minecraft-26.3--snapshot--3-62B47A" alt="Minecraft 26.3-snapshot-3">
  <img src="https://img.shields.io/badge/Fabric-Client--side-DBD0B4?logo=fabric" alt="Fabric client-side mod">
  <a href="LICENSE.txt"><img src="https://img.shields.io/badge/License-MIT-blue" alt="MIT License"></a>
</p>

<p align="center">
  <img src="docs/images/rainbow-cushion.gif" alt="A cushion cycling through rainbow colors in Minecraft" width="480">
</p>

Rainbow Cushion does one thing: it gives cushions named `jeb_` the same color cycle as a `jeb_` sheep. It works with every cushion color and doesn't add any blocks, items, or recipes.

## Using it

1. Rename a cushion to `jeb_` in an anvil.
2. Place it.

Breaking a cushion removes its custom name, so you'll need to rename it before placing it again.

## Installing

You'll need Fabric Loader 0.19.3 or newer and the matching version of [Fabric API](https://modrinth.com/mod/fabric-api).

Download the mod from [Modrinth](https://modrinth.com/mod/rainbowcushion) and put the `.jar` file in your Minecraft `mods` folder.

The current version is built for Minecraft 26.3-snapshot-3 and Java 25.

## Servers

The mod is client-side. Servers don't need it, and other players only need their own copy if they want to see the rainbow effect.

## Building from source

```sh
./gradlew build
```

The finished `.jar` will be in `build/libs`.

## Releasing

Add a repository secret named `MODRINTH_TOKEN`, then update `mod_version` in `gradle.properties` and push a matching tag:

```sh
git tag v1.0.1
git push origin v1.0.1
```

The release workflow builds the mod and publishes the same `.jar` and commit list to GitHub and Modrinth.

## License

[MIT](LICENSE.txt)

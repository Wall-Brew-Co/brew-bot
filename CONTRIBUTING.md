# Contributing

Wall Brew strives to make contributions as simple as possible while ensuring our software consistently meets our standards.

<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->

- [Code of Conduct](#code-of-conduct)
  - [Our Pledge](#our-pledge)
- [Communicating Changes](#communicating-changes)
  - [Read the Documentation](#read-the-documentation)
  - [Where To Start](#where-to-start)
- [Pull Request](#pull-request)
  - [Restricted Files](#restricted-files)
  - [Automatic Formatting](#automatic-formatting)
- [Legal Adherence](#legal-adherence)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

## Code of Conduct

All community members should have a clear and shared understanding of what is considered acceptable and unacceptable behavior.
To prevent ad-hoc or just-in-time rule setting, we have explicitly outlined our expectations and rules in text.
Our Code of Conduct strives to meet three goals:

- Welcome contributors and participants
- Define basic standards and rules for community participation
- Outline procedures for handling abuse and violation of said rules and standards

A full copy of our [code of conduct may be found in any Wall Brew repository.](https://github.com/Wall-Brew-Co/brew-bot/blob/master/CODE_OF_CONDUCT.md)

### Our Pledge

In the interest of fostering an open and welcoming environment, we as contributors and maintainers pledge to making participation in our project and our community a harassment-free experience for everyone, regardless of age, body
size, disability, ethnicity, gender identity and expression, level of experience, nationality, personal appearance, race, religion, or sexual identity and orientation.

A full copy of our code of conduct may be found in any Wall Brew repository.

## Communicating Changes

For small issues, improvements, and bug fixes, feel free to fork any repository and publish a pull request.
A Wall Brew maintainer will be automatically assigned for review, and help you understand any remaining steps to merge your changes.

For larger changes, we ask that you please first discuss the change you wish to make prior to starting work.
This helps ensure the overall design of our libraries remains consistent, and that work is not being duplicated with any planned enhancements.
Once you have reached an agreement with a Wall Brew maintainer, feel free to fork any repository and publish a pull request.
A Wall Brew maintainer will be automatically assigned for review, and help you understand any remaining steps to merge your changes.

For issues, requests, and changes scoped to this repository, please open an [issue or feature request](https://github.com/Wall-Brew-Co/brew-bot/issues/new/choose)
For issues, reports, and changes that span multiple repositories or would change a common development standard, please start [a discussion.](https://github.com/Wall-Brew-Co/open-source/discussions)

Lastly, to effectively communicate changes to our consumers, please follow the conventions of each repository when writing documentation or adding annotative metadata to functionality.
This allows us to cleanly and consistently provide our end-users with a high-quality development experience.

### Read the Documentation

Familiarize yourself with the documentation before you submit a Pull Request.
If you have questions which aren't in the documentation, open a ticket or submit a Pull Request to update the documentation.

### Where To Start

If you're looking for ways to contribute, but don't know where to start, try adding additional tests.
Additionally improving documentation or adding examples as you learn a new project can is an easy way to pitch in.
Finally, check the open [issues and feature requests](https://github.com/nnichols/brew-bot/issues) of the project and ask the maintainers if they are available to be taken on.

## Pull Request

1. Each Wall Brew library follows [SemVer](http://semver.org/ "The Semantic Versioning Scheme"). Please update the version number of any affected projects accordingly.
2. Update the project's [CHANGELOG.md](https://github.com/nnichols/brew-bot/blob/master/CHANGELOG.md) with the new version, date of changes, and a description of the modifications made
3. If any changes impact the external interface or use of the library, please update the [README](https://github.com/nnichols/brew-bot/blob/master/README.md) to reflect any relevant differences or with additional documentation.
4. Be sure to write and update tests that reflect your changes, with good assertion descriptions, and that ensure future contributions will not cause your changes to regress in behavior.
5. Ensure all automated checks pass against your pull request, and make any updates to fix tests, linter warnings, etc.
6. A Wall Brew maintainer will be automatically assigned to review your Pull Request. Please consider any changes or enhancements they may suggest. In some cases, at the discretion of individual Wall Brew maintainers, these changes may be pushed onto your branch or added to any pull request.

### Restricted Files

Wall Brew repositories automatically labels Pull Requests targeting a few select files as `restricted`.
These files are generally related to Wall Brew development policies and standards, and the majority are automatically generated by [rebroadcast.](https://github.com/Wall-Brew-Co/rebroadcast)
Changes to these files should be rare, and will generally only come from members of the Wall-Brew-Co organization.
In most cases, Pull Requests targeting these files will not be accepted until the state of those files is reverted.

### Automatic Formatting

Wall Brew repositories automatically re-format source and test code to match our internal style preferences.
You may forcefully push over these automated commits, but be aware our Pull Request automation will re-format files on each push.
Changes to our formatter configurations are generally considered restricted; however, if they conflict with your developer tooling (e.g. `parinfer`, screen readers) please contact a Wall Brew maintainer with the issue you are facing.
The configuration for code styling tools is automatically maintained by [rebroadcast.](https://github.com/Wall-Brew-Co/rebroadcast)

## Legal Adherence

To ensure Wall Brew libraries adhere to all applicable intellectual property laws, contributors must ensure:

- Their contributions may, in whole, be submitted under the open source license included in the repository
- Their contributions, in any way, do not contain the intellectual property of any entity who has not agreed to the contribution be submitted under the open source license included in the repository
- They understand and agree to the fact that any contribution to this repository is public, and that records of the contribution are maintained indefinitely

<!-- This file was automatically copied and populated by rebroadcast -->
<!-- Do not edit this file directly, instead modify the source at https://github.com/Wall-Brew-Co/rebroadcast -->

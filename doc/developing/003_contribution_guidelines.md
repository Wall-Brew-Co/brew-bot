# Contribution Guidelines

Human interaction is complex and subject to many different lenses of personal, contextual, and cultural influence.
Every individual has their own perception of what they consider to be helpful, harmful, professional, and casual conduct.
Differences in these perceptions can leady to unhealthy or harmful conflicts of opinion, which can cascade into real harm against a person's emotional, physical, and/or mental well-being.
Within a community, it is important to ensure that differences in opinion may be held without adversely impacting any community member.

However, we each individually hold our own perceptions of what a community is and ought to be.
Enforcing any communal rules or standards requires a shared understanding of what is and is not considered acceptable behavior and language.
Without a shared context for a community, fair and even judgement, remediation, and enforcement of community rules and standards is impossible.

Therefore, it is important to be explicit on what boundaries exist and what territory may be adjacent to those boundaries.
Those fostering communities must not only communicate their expectations clearly, but also take care to consistently and promptly enforce those expectations.
In some cases, that requires explicitly removing bad faith members of a community.

Several of our philosophies manifest as concrete requirements that every Wall Brew library and maintainer must uphold.
These are policies and practices which cannot be superseded, ignored, or violated except in the most extreme of situations.
Maintainers are expected to kindly and professionally reinforce our requirements, and to help contributors make the adjustments necessary to meet them as well.
Consistent, intentional, or bad-faith violations of these requirements may be grounds to remove, edit, or reject comments, commits, code, wiki edits, issues, and other contributions, or to ban temporarily or permanently any contributor or maintainer.

Each repository contains a full-text copy of our [Code of Conduct](https://github.com/Wall-Brew-Co/rebroadcast/blob/master/sources/community/CODE_OF_CONDUCT.md), which must be followed at all times.

## Prior to Contributing

Familiarize yourself with the documentation before you submit a Pull Request.
If you have questions which aren't in the documentation, open a ticket or submit a Pull Request to update the documentation.
Prior to starting development on an individual fork, we recommend executing the tests locally to confirm the library and your machine are working as expected.

## Communicating and Contributing Changes

For small issues, improvements, and bug fixes, feel free to fork any repository and publish a pull request.
Please utilize the pull request template to communicate your changes and to ensure that all steps have been completed.
A Wall Brew maintainer will be automatically assigned for review, and help you understand any remaining steps to merge your changes.

For larger changes, we ask that you please first discuss the change you wish to make prior to starting work.
This helps ensure the overall design of our libraries remains consistent, and that work is not being duplicated with any planned enhancements.
Once you have reached an agreement with a Wall Brew maintainer, feel free to fork any repository and publish a pull request.
A Wall Brew maintainer will be automatically assigned for review, and help you understand any remaining steps to merge your changes.

For issues, requests, and changes scoped to this repository, please open an issue or a feature request in that repository.
For issues, reports, and changes that span multiple repositories or would change a common development standard, please start [a discussion.](https://github.com/Wall-Brew-Co/open-source/discussions)

Lastly, to effectively communicate changes to our consumers, please follow the conventions of each repository when writing documentation or adding annotative metadata to functionality.
This allows us to cleanly and consistently provide our end-users with a high-quality development experience.

### Pull Request

1. Each Wall Brew library follows [SemVer](http://semver.org/ "The Semantic Versioning Scheme"). Please update the version number of any affected projects accordingly.
2. Update the project's CHANGELOG with the new version, date of changes, and a description of the modifications made with [sealog](https://github.com/Wall-Brew-Co/lein-sealog)
3. If any changes impact the external interface or use of the library, please update the README to reflect any relevant differences or with additional documentation.
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
<!-- Do not edit this file directly, instead modify the source at https://github.com/Wall-Brew-Co/rebroadcast/blob/master/sources/community/documentation/developing/003_contribution_guidelines.md -->

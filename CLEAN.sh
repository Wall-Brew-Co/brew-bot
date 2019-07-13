#!/usr/bin/env bash

## Correct formatting
lein cljfmt fix

echo " "
echo "Bikeshed Style Analysis"
lein bikeshed -v 2>&1 | tee .bikeshed

echo " "
echo "Eastwood Linting"
lein eastwood 2>&1 | tee .eastwood

echo " "
echo "Unit Tests & Coverage Reporting"
lein cloverage -o docs/coverage

echo " "
echo "Dead Code Reporting"
lein yagni 2>&1 | tee .yagni

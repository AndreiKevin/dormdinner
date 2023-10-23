# dormdinner
MOBDEVE MCO1

## Development

### Branch Naming Convention

- **`feature/<name-of-feature>`** - branch containing the fully-functional feature
  (i.e. will be merged to the `main` branch)
    - ex. `feature/login`, `feature/add-product`

- **`component/<name-of-component>`** - branch containing the fully-functional component
  (i.e. will be merged either to the `main` branch or the `<feature> branch`,
  if it is part of the feature)
    - ex. `component/login-button`, `component/nav-link`

- **`bugfix/<pull-request-id# | merge-id# | name-of-feature | name-of-component>`** - fix before live production (i.e. during development)
    - ex. `bugfix/#24`, `bugfix/add-product`, `bugfix/login-button`

- **`coldfix/<pull-request-id# | merge-id# | name-of-feature | name-of-component>`** - fix while system
  is live, but will require downtime
    - ex. `coldfix/#24`, `coldfix/add-product`, `coldfix/login-button`

- **`hotfix/<pull-request-id# | merge-id# | name-of-feature | name-of-component>`** - fix while system
  is live, and should not create system downtime
    - ex. `hotfix/#24`, `hotfix/add-product`, `hotfix/login-button`

- **`patch/<pull-request-id# | merge-id# | name-of-feature | name-of-component>`** - additional upgrades
  or features
    - ex. `patch/#24`, `patch/add-product`, `patch/login-button`

- **`wip-<feature | component | bugfix | coldfix | hotfix | pathc>/<name | id#>`** - meant for a branch
  that is still not ready to be merged into another branch. For saving progress in remote repository
    - ex. `wip-feature/login`, `wip-component/nav-link`, `wip-bugfix/#24`, `wip-coldfix/add-product`, `wip-hotfix/login-button`, `wip-patch/comment-line-wrap`

### Git Commit Message Convention

- **`feat(<name>): <message>`** - indicates a commit with fully-fuctional feature
    - ex. `"feat(user-login): allow registered user to login to the web app"`

- **`add(<name>): <message>`** - indicates that a component, line, or function was added
    - ex. `"add(add-product-button): added an add product button to the product modal component"`

- **`modify(<name>): <message>`** - indicates that a component, line, or function was edited
  while retaining its functionalities/features (i.e. changing how the component looks or how
  the function should compute)
    - ex. `"modify(product-modal-component): modified width and height"`

- **`fix(<name>): <message>`** - indicates a commit with a fix for a certain bug in a feature,
  component, merge or pull request.
    - ex. `"fix(order-submission-timout): fixed fast timeout when submitting an order"`
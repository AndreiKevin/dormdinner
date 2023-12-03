# dormdinner
Machine Project in MOBDEVE(Mobile Development)


## Authors
- Ang, Audric
- Chua, Andrei
- Griffin, Faith


## Application Description
In the fast-paced life of college students, dormdinner comes to the rescue, simplifying meal preparations and
reducing waste. Inspired by the trendy Dorm Dinner videos on TikTok, this application is specifically designed
to aid college students in cooking up a delightful meal with what's readily available in their dorms. It's pretty
straightforward - users simply log the food items or ingredients on hand, and dormdinner provides recipes!
dormdinner is about turning the constraints of time and resources into a culinary exploration that's both
practical and delightful.


## Service and API used

### Local Database (SQLite)
  Used to store favorite recipes of a user
### **[Spoonacular API](https://spoonacular.com/food-api)**
  Used to generate recipes from ingredients or food items listed by a user

## Implemented Features
| Feature           |                                                                Description                                                                 |
|:------------------|:------------------------------------------------------------------------------------------------------------------------------------------:|
| Add to Pantry     |                                   The user can list ingredients/food items currently available to them.                                    |
| Search Recipe     |                  The list of ingredients/food in their pantry will use the Spoonacular API to generate recipes for them.                   |
| View Recipe       | Once a user selects a recipe, the app will provide the ingredients and the cooking/preparation processes involved in that specific recipe. |
| Favorite Recipe   |                                               The user can store recipes that they enjoyed.                                                |
| Unfavorite Recipe |                                     The user can remove recipes from their favorites list collection.                                      |
| Share Recipe Text |                                       The user can share the recipe in text format with other apps.                                        |


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
var categories = [
  {
    "id": 0,
    "value": "wesley",
  },
  {
    "id": 1,
    "value": "wesley1",
  },
  {
    "id": 2,
    "value": "wesley2",
  },
  {
    "id": 3,
    "value": "wesley3",
  },
]

function addCategory(name) {
  let category = {
    "id": setNextId(),
    "value": name,
  }
  categories.push(category);
}

function getCategories() {
  return categories;
}

function deleteCategories(id) {
  categories = categories.filter((category) => category.id !== parseInt(id))
  return categories;
}

function setNextId() {
  if (categories.length <= 0)
    return 0;

  return categories[categories.length - 1].id + 1;
}

exports.addCategory = addCategory;
exports.getCategories = getCategories;
exports.deleteCategories = deleteCategories;


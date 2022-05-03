var categories = [
  {
    "id": 0,
    "value": "wesley",
    "personalizado": ["personalizado1", "personalizado2"],
  },
  {
    "id": 1,
    "value": "wesley 2",
    "personalizado": ["personalizado3", "personalizado4"],
  },

]

function addCategory(name, personalizado) {
  let category = {
    "id": setNextId(),
    "value": name,
    "personalizado": personalizado,
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

function getCategoryById(id) {
  const catetegory = categories.find(x => x.id == id)

  if (catetegory)
    return catetegory;
  else
    return { "id": 0, "value": "sem categoria" }
}

function setNextId() {
  if (categories.length <= 0)
    return 0;

  return categories[categories.length - 1].id + 1;
}

exports.addCategory = addCategory;
exports.getCategoryById = getCategoryById;
exports.getCategories = getCategories;
exports.deleteCategories = deleteCategories;


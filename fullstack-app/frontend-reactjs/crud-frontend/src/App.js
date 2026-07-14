import React, { useState } from 'react';
import BookList from './components/BookList';
import BookForm from './components/BookForm';
import './index.css';

function App() {
  const [currentBook, setCurrentBook] = useState(null);
  const [refreshLog, setRefreshLog] = useState(0);

  const handleEdit = (book) => {
    setCurrentBook(book);
  };

  const handleSave = () => {
    setCurrentBook(null);
    setRefreshLog(prev => prev + 1); // لتحديث قائمة العرض تلقائياً عند تغيير القيمة
  };

  return (
    <div className="App">
      <h1>Catalog Management Application</h1>
      <BookForm currentBook={currentBook} onSave={handleSave} />
      <BookList key={refreshLog} onEdit={handleEdit} />
    </div>
  );
}

export default App;
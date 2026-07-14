import React, { useState, useEffect } from 'react';
import BookService from '../services/bookService';

const BookForm = ({ currentBook, onSave }) => 
    {
    const [book, setBook] = useState({
        name: '',
        isbn: '',
        publishedDate: '',
        price: '',
        bookType: 'HARD_COVER'
    });

    useEffect(() => {
        if (currentBook) {
            setBook(currentBook);
        }
    }, [currentBook]);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setBook({ ...book, [name]: value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            if (book.id) {
                await BookService.updateBook(book.id, book);
            } else {
                await BookService.addBook(book);
            }
            onSave(); // تحديث الصفحة الرئيسية بعد الحفظ
        } catch (error) {
            console.error("Error saving book", error);
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <input type="text" name="name" value={book.name} onChange={handleChange} placeholder="Book Name" required />
            <input type="text" name="isbn" value={book.isbn} onChange={handleChange} placeholder="ISBN" required />
            <input type="date" name="publishedDate" value={book.publishedDate} onChange={handleChange} required />
            <input type="number" name="price" value={book.price} onChange={handleChange} placeholder="Price" required />
            <select name="bookType" value={book.bookType} onChange={handleChange}>
                <option value="EBOOK">Ebook</option>
                <option value="SOFT_COPY">Soft Copy</option>
                <option value="HARD_COVER">Hard Cover</option>
            </select>
            <button type="submit">{book.id ? "Update Book" : "Add Book"}</button>
        </form>
    );
};

export default BookForm;
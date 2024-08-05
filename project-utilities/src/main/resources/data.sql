INSERT INTO
    person(
        id,
        name,
        email
    )
    VALUES(
        1,
        'John Doe',
        'john.doe@example.com'
    )
    ON CONFLICT(id) DO NOTHING;

SELECT setval('person_id_seq', (SELECT MAX(id) FROM person));
INSERT INTO country VALUES (1, 'Malta');

INSERT INTO country VALUES (2, 'Gozo');

INSERT INTO country VALUES (3, 'Comino');




INSERT INTO public.client VALUES (1, 'Joseph', '1 Line 1', '1 Line 2', 'Qormi', '2 Line 1', '2 Line 2', 'Zebbug', 'Grech', 1, 2);

INSERT INTO public.client VALUES (2, 'Nathalie', '1 Line 1', '1 Line 2', 'Birzebbugia', '2 Line 1', '2 Line 2', 'Marsascala', 'Grima', 2, 3);



/*id, balance, status, type, client_id*/
INSERT INTO public.account VALUES (1, 100, TRUE, TRUE, 1);

INSERT INTO public.account VALUES (2, 100, FALSE, TRUE, 1);

INSERT INTO public.account VALUES (3, 100, TRUE, FALSE, 1);

INSERT INTO public.account VALUES (4, 100, FALSE, TRUE, 2);

INSERT INTO public.account VALUES (5, 100, TRUE, TRUE, 2);